package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Dao;

public class BWriteCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		int sessionIDX = (int) request.getSession().getAttribute("sessionIDX");
		String nickname = request.getParameter("userNickname");
		String title = request.getParameter("bTitle");
		String content = request.getParameter("bContent");
		
		Dao dao = Dao.getInstance();
		int result = dao.bWrite(sessionIDX, nickname, title, content);
		System.out.println(result);

		if(result == 1) {
			request.setAttribute("okBWrite", "1");
		} else if(result == 0) {
			request.setAttribute("okBWrite", "0");
		}
	}

}
