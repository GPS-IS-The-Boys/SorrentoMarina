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
      case "LidoAction":
        return new LidoAction();
      case "AnnunciLidoAction":
        return new AnnunciLidoAction();
      case "DettagliAnnuncioAction":
        return new DettagliAnnuncioAction();
      case "RecensioniLidoAction":
        return new RecensioniLidoAction();
      case "MostraFormRecensione":
        return new MostraFormRecensione();
      case "AggiungiRecensioneChainableAction":
        return new AggiungiRecensioneChainableAction();
      case "MostraPrenotazione1Action":
        return new MostraPrenotazione1Action();
      case "MostraPrenotazione2Action":
        return new MostraPrenotazione2Action();
      case "MostraPrenotazione3Action":
        return new MostraPrenotazione3Action();
      case "MostraPrenotazione4Action":
        return new MostraPrenotazione4Action();
      case "EseguiPrenotazione1Action":
        return new EseguiPrenotazione1Action();
      case "EseguiPrenotazione2Action":
        return new EseguiPrenotazione2Action();
      case "EseguiPrenotazione3Action":
        return new EseguiPrenotazione3Action();
      case "EseguiPrenotazione4Action":
        return new EseguiPrenotazione4Action();
      default:
        return new WelcomeAction();
    }
  }
}