package theboys.sorrentomarina.actions;

import org.junit.jupiter.api.Test;
import theboys.sorrentomarina.actions.actionsAnnuncio.*;
import theboys.sorrentomarina.actions.actionsLido.*;
import theboys.sorrentomarina.actions.actionsPrenotazione.*;
import theboys.sorrentomarina.actions.actionsRecensione.*;
import theboys.sorrentomarina.actions.actionsUtente.*;
import theboys.sorrentomarina.actions.actionsUtils.Action;
import theboys.sorrentomarina.actions.actionsUtils.PageActionFactory;

import static org.junit.jupiter.api.Assertions.*;

public class PageActionFactoryTest {

  private PageActionFactory paf = new PageActionFactory();

  @Test
  public void AdminDashboardTest(){
    Action test = paf.create("AdminDashboard");
    assertEquals(test.getClass(),ShowDashboardAction.class);
  }

  @Test
  public void ShowFormRegistrazioneTest(){
    Action test = paf.create("MostraFormRegistrazioneAction");
    assertEquals(test.getClass(),MostraFormRegistrazioneAction.class);
  }

  @Test
  public void RegistrazioneActionTest(){
    Action test = paf.create("RegistrazioneAction");
    assertEquals(test.getClass(), RegistrazioneAction.class);
  }

  @Test
  public void MostraFormLoginActionTest(){
    Action test = paf.create("MostraFormLoginAction");
    assertEquals(test.getClass(),MostraFormLoginAction.class);
  }

  @Test
  public void CheckLoginTuristaTest(){
    Action test = paf.create("CheckLogin");
    assertEquals(test.getClass(), CheckLoginTurista.class);
  }

  @Test
  public void LogoutActionTest(){
    Action test = paf.create("LogoutAction");
    assertEquals(test.getClass(), LogoutAction.class);
  }

  @Test
  public void MostraProfiloActionTest(){
    Action test = paf.create("MostraProfilo");
    assertEquals(test.getClass(), MostraProfiloAction.class);
  }

  @Test
  public void ShowPrenotazioniTuristaTest(){
    Action test = paf.create("PrenotazioniTurista");
    assertEquals(test.getClass(), ShowPrenotazioniTurista.class);
  }

  @Test
  public void ModificaCredenzialiActionTest(){
    Action test = paf.create("ModificaCredenziali");
    assertEquals(test.getClass(), ModificaCredenzialiAction.class);
  }

  @Test
  public void LidoActionTest(){
    Action test = paf.create("LidoAction");
    assertEquals(test.getClass(), LidoAction.class);
  }

  @Test
  public void AnnunciLidoActionTest(){
    Action test = paf.create("AnnunciLidoAction");
    assertEquals(test.getClass(), AnnunciLidoAction.class);
  }

  @Test
  public void MostraInfoActionTest(){
    Action test = paf.create("InfoAction");
    assertEquals(test.getClass(),MostraInfoAction.class);
  }

  @Test
  public void RecensioniLidoActionTest(){
    Action test = paf.create("RecensioniLidoAction");
    assertEquals(test.getClass(),RecensioniLidoAction.class);
  }

  @Test
  public void MostraFormRecensioneTest(){
    Action test = paf.create("MostraFormRecensione");
    assertEquals(test.getClass(), MostraFormRecensione.class);
  }

  @Test
  public void MostraPrevisioniTest(){
    Action test = paf.create("MostraPrevisioni");
    assertEquals(test.getClass(),MostraPrevisioni.class);
  }

  @Test
  public void MostraAffluenzaTest(){
    Action test = paf.create("MostraAffluenza");
    assertEquals(test.getClass(), MostraAffluenza.class);
  }

  @Test
  public void AggiungiRecensioneChainableActionTest(){
    Action test = paf.create("AggiungiRecensioneChainableAction");
    assertEquals(test.getClass(), AggiungiRecensioneChainableAction.class);
  }

  @Test
  public void MostraPrenotazione1ActionTest(){
    Action test = paf.create("MostraPrenotazioneAction");
    assertEquals(test.getClass(), MostraPrenotazioneAction.class);
  }

  @Test
  public void EseguiPrenotazione1ActionTest(){
    Action test = paf.create("EseguiPrenotazioneAction");
    assertEquals(test.getClass(), EseguiPrenotazioneAction.class);
  }

  @Test
  public void CreaAnnuncioActionTest(){
    Action test = paf.create("CreaAnnuncioAction");
    assertEquals(test.getClass(), CreaAnnuncioAction.class);
  }

  @Test
  public void ShowDashboardEnteActionTest(){
    Action test = paf.create("ShowDashboardEnte");
    assertEquals(test.getClass(),ShowDashboardEnteAction.class);
  }

  @Test
  public void MostraCreaLidoTest(){
    Action test = paf.create("MostraCreaLido");
    assertEquals(test.getClass(), MostraCreaLido.class);
  }

  @Test
  public void CreaLidoActionTest(){
    Action test = paf.create("CreaLido");
    assertEquals(test.getClass(), CreaLidoAction.class);
  }

  @Test
  public void PostiOccupatiTest(){
    Action test = paf.create("PostiOccupati");
    assertEquals(test.getClass(), PostiOccupati.class);
  }

  @Test
  public void ListaSelezionatiTest(){
    Action test = paf.create("ListaSelezionati");
    assertEquals(test.getClass(), ListaSelezionati.class);
  }

  @Test
  public void RimuoviLidoActionTest(){
    Action test = paf.create("RimuoviLido");
    assertEquals(test.getClass(),RimuoviLidoAction.class);
  }

  @Test
  public void MostraAnnunciRespLidoActionTest(){
    Action test = paf.create("AnnunciRespLido");
    assertEquals(test.getClass(),MostraAnnunciRespLidoAction.class);
  }

  @Test
  public void EliminaAnnuncioRespLidoTest(){
    Action test = paf.create("EliminaAnnuncio");
    assertEquals(test.getClass(), EliminaAnnuncioRespLido.class);
  }

  @Test
  public void ModificaAnnuncioRespLidoActionTest(){
    Action test = paf.create("ModificaAnnuncio");
    assertEquals(test.getClass(),ModificaAnnuncioRespLidoAction.class);
  }

  @Test
  public void MostraRecensioniRespLidoActionTest(){
    Action test = paf.create("RecensioniRespLido");
    assertEquals(test.getClass(), MostraRecensioniRespLidoAction.class);
  }

  @Test
  public void RimuoviRecensioneActionTest(){
    Action test = paf.create("CancellaRecensione");
    assertEquals(test.getClass(), RimuoviRecensioneAction.class);
  }

  @Test
  public void MostraTuttiAnnunciTest(){
    Action test = paf.create("MostraTuttiAnnunci");
    assertEquals(test.getClass(), MostraTuttiAnnunci.class);
  }

  @Test
  public void MostraTutteRecensioniTest(){
    Action test = paf.create("MostraTutteRecensioni");
    assertEquals(test.getClass(), MostraTutteRecensioni.class);
  }

  @Test
  public void MostraModificaLidoTest(){
    Action test = paf.create("MostraModificaLido");
    assertEquals(test.getClass(),MostraModificaLido.class);
  }

  @Test
  public void ModificaLidoActionTest(){
    Action test = paf.create("ModificaLido");
    assertEquals(test.getClass(), ModificaLidoAction.class);
  }

  @Test
  public void MostraDisponibilitaRespLidoActionTest(){
    Action test = paf.create("MostraDisponibilita");
    assertEquals(test.getClass(),MostraDisponibilitaRespLidoAction.class);
  }

  @Test
  public void DettagliAnnuncioActionTest(){
    Action test = paf.create("DettagliAnnuncioAction");
    assertEquals(test.getClass(), DettagliAnnuncioAction.class);
  }

  @Test
  public void DefaultTest(){
    Action test = paf.create("");
    assertEquals(test.getClass(),WelcomeAction.class);
  }


}
