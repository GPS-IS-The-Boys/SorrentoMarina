package theboys.sorrentomarina.router;

import theboys.sorrentomarina.actions.Action;

import java.io.IOException;
import java.util.HashMap;
import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import theboys.sorrentomarina.actions.PageActionFactory;

/**
 * @author theboys
 */
@WebServlet(name = "FrontController", urlPatterns = {"/SorrentoMarina/*"})
public class FrontController extends HttpServlet {

  private static final Router ROUTER = new Router(new HashMap<>());
  private static final PageActionFactory PAF = new PageActionFactory();

  @Resource(name = "jdbc/SorrentoDB")
  private DataSource dataSource;

  @Override
  public void init() throws ServletException {
    getServletContext().setAttribute("db", dataSource);
    ROUTER.get("/", PAF.create("WelcomeAction"));
    ROUTER.get("/index", PAF.create("WelcomeAction"));
    ROUTER.get("/dashboard", PAF.create("AdminDashboard"));
    ROUTER.get("/registrazione", PAF.create("MostraFormRegistrazioneAction"));
    ROUTER.post("/registrazione_account", PAF.create("RegistrazioneAction"));
    ROUTER.get("/login", PAF.create("MostraFormLoginAction"));
    ROUTER.post("/login_account", PAF.create("CheckLogin"));
    ROUTER.get("/logout", PAF.create("LogoutAction"));
    ROUTER.get("/profilo", PAF.create("MostraProfilo"));
    ROUTER.get("/prenotazioniTurista", PAF.create("PrenotazioniTurista"));
    ROUTER.post("/modificaCredenziali", PAF.create("ModificaCredenziali"));
    ROUTER.get("/lido", PAF.create("LidoAction"));
    ROUTER.get("/annunciLido", PAF.create("AnnunciLidoAction"));
    ROUTER.get("/dettagliAnnuncio", PAF.create("DettagliAnnuncioAction"));
    ROUTER.get("/recensioniLido", PAF.create("RecensioniLidoAction"));
    ROUTER.get("/formRecensione", PAF.create("MostraFormRecensione"));
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    processRequest(HttpMethod.GET, request, response);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    processRequest(HttpMethod.POST, request, response);
  }

  private void processRequest(HttpMethod method, HttpServletRequest req, HttpServletResponse res)
      throws ServletException, IOException {
    Action action = ROUTER.handleRoute(method, req.getPathInfo());
    String result = action.execute(req, res);
    req.getRequestDispatcher(result).forward(req, res);
  }
}