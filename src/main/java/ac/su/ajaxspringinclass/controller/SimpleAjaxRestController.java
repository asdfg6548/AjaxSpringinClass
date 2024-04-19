package ac.su.ajaxspringinclass.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleAjaxRestController {
    @RequestMapping("/simple-ajax-test1")
    public String getWithNoParameter1() {
        return "XHR 객체를 사용한 GET 요청1";
        //XHR XMLHttpRequest (실제로는 json 데이터로 통신)
    }

    @RequestMapping("/simple-ajax-test2")
    public String getWithNoParameter2() {
        return "fetch() 함수를 사용한 GET 요청2";
        // JS 함수 중 fetch 사용시 AJAX 요청이 가장 손쉬움
        // 처리 방식도 표준적, 모던 JS 에서 선호하는 방법임
    }
}
