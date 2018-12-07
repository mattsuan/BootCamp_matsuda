package jp.co.netprotections.service;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.springframework.boot.test.context.SpringBootTest;

import jp.co.netprotections.dto.RequestDto;
import jp.co.netprotections.dto.ResponseDto;
import jp.co.netprotections.service.impl.MemberJudgeServiceImpl;

@RunWith(JUnit4.class)
@SpringBootTest
public class MemberJudgeServiceTest {

    @Test
       public void ServiceImplTest1() {
        System.out.println("judgeメソッドのテストです");

        //インスタンスの初期化
        RequestDto request1 = new RequestDto();
        MemberJudgeServiceImpl response1 = new MemberJudgeServiceImpl();

        request1.setEventPlanning(2);
        request1.setCogitation(2);
        request1.setCoordination(2);
        request1.setProgrammingKnowledge(3);
        request1.setInfrastructureKnowledge(2);
        request1.setMemberName("Takashi");
        //↑コンストラクタ設定すると良いが、それは余裕あったらでいい。

        //期待する値の設定
        String expectedName = "Takashi";
        boolean expectedPropriety = true;


        //実際の値（テスト先のメソッド通した値）の設定
        ResponseDto actualResponse = response1.judge(request1);
        String actualName = actualResponse.getResponseMemberName();
        boolean actualPropriety = actualResponse.isEnlistedPropriety();


        //期待する値と実際の値の比較
        assertEquals(expectedName, actualName);
        assertEquals(expectedPropriety, actualPropriety);


    }










}
