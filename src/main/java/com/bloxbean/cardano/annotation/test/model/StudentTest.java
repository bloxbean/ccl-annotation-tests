package com.bloxbean.cardano.annotation.test.model;

import com.bloxbean.cardano.client.common.cbor.CborSerializationUtil;
import com.bloxbean.cardano.client.plutus.spec.ConstrPlutusData;
import com.bloxbean.cardano.client.util.HexUtil;

import java.util.List;
import java.util.Optional;

public class StudentTest {

    private com.bloxbean.cardano.annotation.test.model.StudentPlutusDataConverter converter = new com.bloxbean.cardano.annotation.test.model.StudentPlutusDataConverter();

    public String serialize() throws Exception {
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
        return HexUtil.encodeHexString(CborSerializationUtil.serialize(constr.serialize()));
    }

    public void deserialize() throws Exception {
        String serialize = serialize();

        Student student = converter.deserialize(ConstrPlutusData.deserialize(CborSerializationUtil.deserialize(HexUtil.decodeHexString(serialize))));

        System.out.println(student);
    }

    public static void main(String[] args) throws Exception {
        StudentTest test = new StudentTest();
        test.deserialize();
    }
}
