package com.bloxbean.cardano.annotation.test.model;

import com.bloxbean.cardano.client.common.cbor.CborSerializationUtil;
import com.bloxbean.cardano.client.plutus.spec.ConstrPlutusData;
import com.bloxbean.cardano.client.util.HexUtil;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class StudentSerDeTest {
    com.bloxbean.cardano.annotation.test.model.StudentPlutusDataConverter converter
            = new com.bloxbean.cardano.annotation.test.model.StudentPlutusDataConverter();

    @Test
    void serialize() throws Exception {
        Student student = new Student();
        student.setName("John");
        student.setAge(20);
        student.setGender("M");

        Subject subject1 = new Subject();
        subject1.setName("Maths");
        subject1.setMarks(90);
        subject1.setLogo(new byte[] {1,2,3,4,5});
        subject1.setId(Optional.of(new byte[]{1,2}));

        Subject subject2 = new Subject();
        subject2.setName("Science");
        subject2.setMarks(80);
        subject2.setLogo(new byte[] {6,7,8,9,10});
        subject2.setId(Optional.empty());

        student.setSubjects(List.of(subject1, subject2));
        student.setHobby(Optional.of("Cricket"));

        var constr = converter.serialize(student);
        var serilizeHex = constr.serializeToHex();

        Student deStudent = converter.deserialize(ConstrPlutusData.deserialize(CborSerializationUtil.deserialize(HexUtil.decodeHexString(serilizeHex))));

        System.out.println(deStudent);

        assertThat(deStudent.getName()).isEqualTo(student.getName());
        assertThat(deStudent.getAge()).isEqualTo(student.getAge());
        assertThat(deStudent.getGender()).isEqualTo(student.getGender());
        //Add more assertions
        assertThat(deStudent.getSubjects().size()).isEqualTo(student.getSubjects().size());
        assertThat(deStudent.getSubjects().get(0).getName()).isEqualTo(student.getSubjects().get(0).getName());
        assertThat(deStudent.getSubjects().get(0).getMarks()).isEqualTo(student.getSubjects().get(0).getMarks());
        assertThat(deStudent.getSubjects().get(0).getLogo()).isEqualTo(student.getSubjects().get(0).getLogo());
        assertThat(deStudent.getSubjects().get(0).getId().get()).isEqualTo(student.getSubjects().get(0).getId().get());
        assertThat(deStudent.getSubjects().get(1).getName()).isEqualTo(student.getSubjects().get(1).getName());
        assertThat(deStudent.getSubjects().get(1).getMarks()).isEqualTo(student.getSubjects().get(1).getMarks());
        assertThat(deStudent.getSubjects().get(1).getLogo()).isEqualTo(student.getSubjects().get(1).getLogo());
        assertThat(deStudent.getSubjects().get(1).getId()).isEqualTo(Optional.empty());
    }

}
