package theboys.sorrentomarina.actions;

import theboys.sorrentomarina.actions.account.AuthorizeAdminAction;


/**
 * @author theBoys
 */
public class PageActionFactory implements ActionFactory {

  private static final UnauthorizedAction UN_ACTION = new UnauthorizedAction();
  private static final AuthorizeAdminAction AA_ACTION = new AuthorizeAdminAction();

  @Override
  public Action create(String type) {
    return switch (type) {
      case "AdminDashboard" -> new ShowDashboardAction();
      case "MostraFormRegistrazioneAction" -> new MostraFormRegistrazioneAction();
      case "RegistrazioneAction" -> new RegistrazioneAction();
      case "MostraFormLoginAction" -> new MostraFormLoginAction();
      case "CheckLogin" -> new CheckLoginTurista();
      case "PrenotazioniTurista" -> new ShowPrenotazioniTurista();
      default -> new WelcomeAction();
    };
  }

}
