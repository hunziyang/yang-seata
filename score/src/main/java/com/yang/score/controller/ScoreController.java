package com.yang.score.controller;


import com.yang.score.config.result.Result;
import com.yang.score.entity.Score;
import com.yang.score.mapper.ScoreMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/score")
public class ScoreController {

    @Autowired
    private ScoreMapper scoreMapper;

//    @GlobalTransactional(rollbackFor = Exception.class)
    @GetMapping
    public Result setScore(@RequestParam("id") Long id){
        Score score = new Score();
        score.setTradeId(id);
        score.setScore(10);
        scoreMapper.insert(score);
        return Result.success();
    }
}
