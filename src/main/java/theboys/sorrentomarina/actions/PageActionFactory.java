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
      case "InfoAction":
        return new MostraInfoAction();
      case "DettagliAnnuncioAction":
        return new DettagliAnnuncioAction();
      case "RecensioniLidoAction":
        return new RecensioniLidoAction();
      case "MostraFormRecensione":
        return new MostraFormRecensione();
      case "MostraPrevisioni":
        return new MostraPrevisioni();
      case "MostraAffluenza":
        return new MostraAffluenza();
      case "AggiungiRecensioneChainableAction":
        return new AggiungiRecensioneChainableAction();
      case "MostraPrenotazione1Action":
        return new MostraPrenotazione1Action();
      case "EseguiPrenotazione1Action":
        return new EseguiPrenotazione1Action();
      case "CreaAnnuncioAction":
        return new CreaAnnuncioAction();
      case "ShowDashboardEnte":
        return new ShowDashboardEnteAction();
      case "MostraCreaLido":
        return new MostraCreaLido();
      case "CreaLido":
        return new CreaLidoAction();
      case "RimuoviLido":
        return new RimuoviLidoAction();
      case "AnnunciRespLido":
        return new MostraAnnunciRespLidoAction();
      case "EliminaAnnuncio":
        return new EliminaAnnuncioRespLido();
      case "ModificaAnnuncio":
        return new ModificaAnnuncioRespLidoAction();
      case "RecensioniRespLido":
        return new MostraRecensioniRespLidoAction();
      case "CancellaRecensione":
        return new RimuoviRecensioneAction();
      case "MostraTuttiAnnunci":
        return new MostraTuttiAnnunci();
      case "MostraTutteRecensioni":
        return new MostraTutteRecensioni();
      default:
        return new WelcomeAction();
    }
  }
}