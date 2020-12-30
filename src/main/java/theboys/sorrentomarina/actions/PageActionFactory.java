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
    switch (type) {
      case "AdminDashboard":
        return new ShowDashboardAction();
      case "MostraFormRegistrazioneAction":
        return new MostraFormRegistrazioneAction();
      case "RegistrazioneAction":
        return new RegistrazioneAction();
      case "MostraFormLoginAction":
        return new MostraFormLoginAction();
      case "CheckLogin":
        return new CheckLoginTurista();
      case "LogoutAction":
        return new LogoutAction();
      case "MostraProfilo":
        return new MostraProfiloAction();
      case "PrenotazioniTurista":
        return new ShowPrenotazioniTurista();
      case "ModificaCredenziali":
        return new ModificaCredenzialiAction();
      default:
        return new WelcomeAction();
    }
  }
}