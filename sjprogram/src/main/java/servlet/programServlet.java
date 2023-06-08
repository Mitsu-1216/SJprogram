package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Site;
import model.SiteLogic;

@WebServlet("/Index")
public class Index extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// アプリケーションスコープに保存されたサイトの評価を取得
		ServletContext application = this.getServletContext();
		Site site = (Site) application.getAttribute("site");

		// サイト評価の初期化
		if (site == null) {
			site = new Site();
		}

		request.setCharacterEncoding("UTF-8");
		String action = request.getParameter("action");

		// サイトの評価処理
		SiteLogic siteLogic = new SiteLogic();
		if (action != null && action.equals("like")) {
			siteLogic.like(site);
		} else if (action != null && action.equals("dislike")) {
			siteLogic.dislike(site);
		}

		// アプリケーションスコープにサイト評価を保存
		application.setAttribute("site", site);

		// フォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Index.jsp");
		dispatcher.forward(request, response);
	}

}
