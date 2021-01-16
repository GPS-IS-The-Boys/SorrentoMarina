package theboys.sorrentomarina.actions.actionsUtils;


import theboys.sorrentomarina.actions.actionsAnnuncio.*;
import theboys.sorrentomarina.actions.actionsLido.*;
import theboys.sorrentomarina.actions.actionsPrenotazione.*;
import theboys.sorrentomarina.actions.actionsRecensione.*;
import theboys.sorrentomarina.actions.actionsUtente.*;

/**
 * @author theBoys
 */
public class PageActionFactory implements ActionFactory {


  /**
   * Esegue la action e associa una stringa ad una chiamata di funzione
   *
   * @param type
   * @return un action
   */
  @Override
  public Action create(String type) {
    switch (type) {
      case "AdminDashboard":
        return new MostraDashboardAction();
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
        return new MostraPrenotazioniTurista();
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
      case "MostraPrenotazioneAction":
        return new MostraPrenotazioneAction();
      case "EseguiPrenotazioneAction":
        return new EseguiPrenotazioneAction();
      case "CreaAnnuncioAction":
        return new CreaAnnuncioAction();
      case "ShowDashboardEnte":
        return new MostraDashboardEnteAction();
      case "MostraCreaLido":
        return new MostraCreaLido();
      case "CreaLido":
        return new CreaLidoAction();
      case "PostiOccupati":
        return new PostiOccupati();
      case "ListaSelezionati":
        return new ListaSelezionati();
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
      case "MostraModificaLido":
        return new MostraModificaLido();
      case "ModificaLido":
        return new ModificaLidoAction();
      case "MostraDisponibilita":
        return new MostraDisponibilitaRespLidoAction();
      default:
        return new WelcomeAction();
    }
  }
}