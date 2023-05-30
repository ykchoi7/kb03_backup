package web0420.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** 요청을 처리하는 클래스의 실행을 위한 타입 정의 - execute() 메서드 필요 */

public interface Controller {
	void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
