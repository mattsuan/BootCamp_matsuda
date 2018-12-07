package jp.co.netprotections.service;

import org.springframework.stereotype.Service;

import jp.co.netprotections.dto.RequestDto;
import jp.co.netprotections.dto.ResponseDto;

@Service
public interface MemberJudgeService {

    public ResponseDto judge(RequestDto request);


}
