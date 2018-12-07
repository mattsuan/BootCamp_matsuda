package jp.co.netprotecionts.listToListTest;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.springframework.boot.test.context.SpringBootTest;

import jp.co.netprotections.dto.MemberRequestListDto;
import jp.co.netprotections.dto.RequestDto;
import jp.co.netprotections.dto.ResponseDto;
import jp.co.netprotections.listToList.ListToList;

@RunWith(JUnit4.class)
@SpringBootTest
public class listToListTest {

  @Test
  public void listToListTest () {


      //インスタンスの初期化
    RequestDto requestData = new RequestDto();
    ResponseDto responseData = new ResponseDto();
    MemberRequestListDto requestList = new MemberRequestListDto();
    List<ResponseDto> responseList = new ArrayList<ResponseDto>();
    ListToList JudgedList = new ListToList();


    //期待する値の設定
    requestData.setMemberName("tmatsuda");
    requestData.setEventPlanning(1);
    requestData.setCogitation(3);
    requestData.setCoordination(2);
    requestData.setProgrammingKnowledge(3);
    requestData.setInfrastructureKnowledge(2);
    requestList.addMemberRequestList(requestData);;

    responseData.setResponseMemberName("tmatsuda");
    responseData.setEnlistedPropriety(false);
    responseList.add(responseData);

    RequestDto requestData2 = new RequestDto();

    requestData2.setMemberName("kyamaura");
    requestData2.setEventPlanning(4);
    requestData2.setCogitation(3);
    requestData2.setCoordination(5);
    requestData2.setProgrammingKnowledge(2);
    requestData2.setInfrastructureKnowledge(5);

    requestList.addMemberRequestList(requestData2);

    ResponseDto responseData2 = new ResponseDto();

    responseData2.setResponseMemberName("kyamaura");
    responseData2.setEnlistedPropriety(true);
    responseList.add(responseData2);

    String expectedName1 = "tmatsuda";
    boolean expectedPropriety1 = false;

    String expectedName2 = "kyamaura";
    boolean expectedPropriety2 = true;



    //実際の値（テスト先のメソッド通した値）の設定
    List<ResponseDto> actualList = JudgedList.listToList(requestList);

    ResponseDto actualMemberData1 = actualList.get(0);
    ResponseDto actualMemberData2 = actualList.get(1);

    String actualName1 = actualMemberData1.getResponseMemberName();
    boolean actualPropriety1 = actualMemberData1.isEnlistedPropriety();

    String actualName2 = actualMemberData2.getResponseMemberName();
    boolean actualPropriety2 = actualMemberData2.isEnlistedPropriety();



    //期待する値と実際の値の比較
    assertEquals(requestData.getMemberName(), "tmatsuda");
    assertEquals(actualList.size(), 2);
    assertEquals(expectedName1, actualName1);
    assertEquals(expectedPropriety1, actualPropriety1);
    assertEquals(expectedName2, actualName2);
    assertEquals(expectedPropriety2, actualPropriety2);



//      {
//          "memberCandidatesList" : [
//              {
//                  "memberName" : "tmatsuda",
//                  "eventPlanning" : "1",
//                  "cogitation" : "3",
//                  "cordination" : "2",
//                  "programmingKnowledge" : "3",
//                  "infrastructureKnowledge" : "2"
//              },
//              {
//                  "memberName" : "kyamaura",
//                  "eventPlanning" : "4",
//                  "cogitation" : "3",
//                  "cordination" : "5",
//                  "programmingKnowledge" : "2",
//                  "infrastructureKnowledge" : "5"
//
//              }
//          ]
//      }


  }

}
