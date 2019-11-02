package com.xing.xing.controller.ParseJSON;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.xing.xing.entity.testData.Question;
import com.xing.xing.entity.testData.Task;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@CrossOrigin(value = "*")
public class ParseController {
    public Object parseJSON(@RequestBody JSONObject param){
        //使用JSONOject接收整个json参数，放在param变量中
//        从JSON数据中拿到task数据并转换为Java对象
        JSONObject task_json = param.getJSONObject("task");
        Task task = (Task)JSONObject.toJavaObject(task_json,Task.class);


        JSONObject questionare_json = param.getJSONObject("questionare");
        JSONArray questions_json = questionare_json.getJSONArray("questions");
        for(int i = 0; i < questions_json.size(); i++){
            JSONObject question_json = (JSONObject)questions_json.getJSONObject(i); //这里不能是get(i),get(i)只会得到键值对
            Question question = (Question)JSONObject.toJavaObject(question_json,Question.class);

        }
        return task;
    }
}
