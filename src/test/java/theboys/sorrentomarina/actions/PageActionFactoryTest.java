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
/**
 * @author theBoys
 *
 */
public class PageActionFactoryTest {

  private PageActionFactory paf = new PageActionFactory();

  /**
   * Test- Crea action AdminDashboard
   */

  @Test
  public void AdminDashboardTest(){
    Action test = paf.create("AdminDashboard");
    assertEquals(test.getClass(), MostraDashboardAction.class);
  }

  /**
   * Test- Crea action MostraFormRegistrazioneAction
   */
  @Test
  public void ShowFormRegistrazioneTest(){
    Action test = paf.create("MostraFormRegistrazioneAction");
    assertEquals(test.getClass(),MostraFormRegistrazioneAction.class);
  }
  /**
   * Test- Crea action RegistrazioneAction
   */
  @Test
  public void RegistrazioneActionTest(){
    Action test = paf.create("RegistrazioneAction");
    assertEquals(test.getClass(), RegistrazioneAction.class);
  }
  /**
   * Test- Crea action MostraFormLoginAction
   */
  @Test
  public void MostraFormLoginActionTest(){
    Action test = paf.create("MostraFormLoginAction");
    assertEquals(test.getClass(),MostraFormLoginAction.class);
  }
  /**
   * Test- Crea action CheckLogin
   */
  @Test
  public void CheckLoginTuristaTest(){
    Action test = paf.create("CheckLogin");
    assertEquals(test.getClass(), CheckLoginTurista.class);
  }
  /**
   * Test- Crea action LogoutAction
   */
  @Test
  public void LogoutActionTest(){
    Action test = paf.create("LogoutAction");
    assertEquals(test.getClass(), LogoutAction.class);
  }
  /**
   * Test- Crea action MostraProfilo
   */
  @Test
  public void MostraProfiloActionTest(){
    Action test = paf.create("MostraProfilo");
    assertEquals(test.getClass(), MostraProfiloAction.class);
  }
  /**
   * Test- Crea action PrenotazioniTurista
   */
  @Test
  public void ShowPrenotazioniTuristaTest(){
    Action test = paf.create("PrenotazioniTurista");
    assertEquals(test.getClass(), MostraPrenotazioniTurista.class);
  }
  /**
   * Test- Crea action ModificaCredenziali
   */
  @Test
  public void ModificaCredenzialiActionTest(){
    Action test = paf.create("ModificaCredenziali");
    assertEquals(test.getClass(), ModificaCredenzialiAction.class);
  }
  /**
   * Test- Crea action LidoAction
   */
  @Test
  public void LidoActionTest(){
    Action test = paf.create("LidoAction");
    assertEquals(test.getClass(), LidoAction.class);
  }
  /**
   * Test- Crea action AnnunciLidoAction
   */
  @Test
  public void AnnunciLidoActionTest(){
    Action test = paf.create("AnnunciLidoAction");
    assertEquals(test.getClass(), AnnunciLidoAction.class);
  }
  /**
   * Test- Crea action InfoAction
   */
  @Test
  public void MostraInfoActionTest(){
    Action test = paf.create("InfoAction");
    assertEquals(test.getClass(),MostraInfoAction.class);
  }
  /**
   * Test- Crea action RecensioniLidoAction
   */
  @Test
  public void RecensioniLidoActionTest(){
    Action test = paf.create("RecensioniLidoAction");
    assertEquals(test.getClass(),RecensioniLidoAction.class);
  }
  /**
   * Test- Crea action MostraFormRecensione
   */
  @Test
  public void MostraFormRecensioneTest(){
    Action test = paf.create("MostraFormRecensione");
    assertEquals(test.getClass(), MostraFormRecensione.class);
  }
  /**
   * Test- Crea action MostraPrevisioni
   */
  @Test
  public void MostraPrevisioniTest(){
    Action test = paf.create("MostraPrevisioni");
    assertEquals(test.getClass(),MostraPrevisioni.class);
  }
  /**
   * Test- Crea action MostraAffluenza
   */
  @Test
  public void MostraAffluenzaTest(){
    Action test = paf.create("MostraAffluenza");
    assertEquals(test.getClass(), MostraAffluenza.class);
  }
  /**
   * Test- Crea action AggiungiRecensioneChainableAction
   */
  @Test
  public void AggiungiRecensioneChainableActionTest(){
    Action test = paf.create("AggiungiRecensioneChainableAction");
    assertEquals(test.getClass(), AggiungiRecensioneChainableAction.class);
  }
  /**
   * Test- Crea action MostraPrenotazione1Action
   */
  @Test
  public void MostraPrenotazione1ActionTest(){
    Action test = paf.create("MostraPrenotazioneAction");
    assertEquals(test.getClass(), MostraPrenotazioneAction.class);
  }
  /**
   * Test- Crea action EseguiPrenotazione1Action
   */
  @Test
  public void EseguiPrenotazione1ActionTest(){
    Action test = paf.create("EseguiPrenotazioneAction");
    assertEquals(test.getClass(), EseguiPrenotazioneAction.class);
  }
  /**
   * Test- Crea action CreaAnnuncioAction
   */
  @Test
  public void CreaAnnuncioActionTest(){
    Action test = paf.create("CreaAnnuncioAction");
    assertEquals(test.getClass(), CreaAnnuncioAction.class);
  }
  /**
   * Test- Crea action ShowDashboardEnte
   */
  @Test
  public void ShowDashboardEnteActionTest(){
    Action test = paf.create("ShowDashboardEnte");
    assertEquals(test.getClass(), MostraDashboardEnteAction.class);
  }
  /**
   * Test- Crea action MostraCreaLido
   */

  @Test
  public void MostraCreaLidoTest(){
    Action test = paf.create("MostraCreaLido");
    assertEquals(test.getClass(), MostraCreaLido.class);
  }
  /**
   * Test- Crea action CreaLido
   */
  @Test
  public void CreaLidoActionTest(){
    Action test = paf.create("CreaLido");
    assertEquals(test.getClass(), CreaLidoAction.class);
  }
  /**
   * Test- Crea action PostiOccupati
   */
  @Test
  public void PostiOccupatiTest(){
    Action test = paf.create("PostiOccupati");
    assertEquals(test.getClass(), PostiOccupati.class);
  }
  /**
   * Test- Crea action ListaSelezionati
   */
  @Test
  public void ListaSelezionatiTest(){
    Action test = paf.create("ListaSelezionati");
    assertEquals(test.getClass(), ListaSelezionati.class);
  }
  /**
   * Test- Crea action RimuoviLido
   */
  @Test
  public void RimuoviLidoActionTest(){
    Action test = paf.create("RimuoviLido");
    assertEquals(test.getClass(),RimuoviLidoAction.class);
  }
  /**
   * Test- Crea action AnnunciRespLido
   */
  @Test
  public void MostraAnnunciRespLidoActionTest(){
    Action test = paf.create("AnnunciRespLido");
    assertEquals(test.getClass(),MostraAnnunciRespLidoAction.class);
  }
  /**
   * Test- Crea action EliminaAnnuncio
   */
  @Test
  public void EliminaAnnuncioRespLidoTest(){
    Action test = paf.create("EliminaAnnuncio");
    assertEquals(test.getClass(), EliminaAnnuncioRespLido.class);
  }
  /**
   * Test- Crea action ModificaAnnuncio
   */

  @Test
  public void ModificaAnnuncioRespLidoActionTest(){
    Action test = paf.create("ModificaAnnuncio");
    assertEquals(test.getClass(),ModificaAnnuncioRespLidoAction.class);
  }
  /**
   * Test- Crea action RecensioniRespLido
   */
  @Test
  public void MostraRecensioniRespLidoActionTest(){
    Action test = paf.create("RecensioniRespLido");
    assertEquals(test.getClass(), MostraRecensioniRespLidoAction.class);
  }
  /**
   * Test- Crea action CancellaRecensione
   */
  @Test
  public void RimuoviRecensioneActionTest(){
    Action test = paf.create("CancellaRecensione");
    assertEquals(test.getClass(), RimuoviRecensioneAction.class);
  }
  /**
   * Test- Crea action MostraTuttiAnnunci
   */
  @Test
  public void MostraTuttiAnnunciTest(){
    Action test = paf.create("MostraTuttiAnnunci");
    assertEquals(test.getClass(), MostraTuttiAnnunci.class);
  }
  /**
   * Test- Crea action MostraTutteRecensioni
   */
  @Test
  public void MostraTutteRecensioniTest(){
    Action test = paf.create("MostraTutteRecensioni");
    assertEquals(test.getClass(), MostraTutteRecensioni.class);
  }
  /**
   * Test- Crea action MostraModificaLido
   */
  @Test
  public void MostraModificaLidoTest(){
    Action test = paf.create("MostraModificaLido");
    assertEquals(test.getClass(),MostraModificaLido.class);
  }
  /**
   * Test- Crea action ModificaLido
   */
  @Test
  public void ModificaLidoActionTest(){
    Action test = paf.create("ModificaLido");
    assertEquals(test.getClass(), ModificaLidoAction.class);
  }
  /**
   * Test- Crea action MostraDisponibilita
   */
  @Test
  public void MostraDisponibilitaRespLidoActionTest(){
    Action test = paf.create("MostraDisponibilita");
    assertEquals(test.getClass(),MostraDisponibilitaRespLidoAction.class);
  }
  /**
   * Test- Crea action DettagliAnnuncioAction
   */
  @Test
  public void DettagliAnnuncioActionTest(){
    Action test = paf.create("DettagliAnnuncioAction");
    assertEquals(test.getClass(), DettagliAnnuncioAction.class);
  }
  /**
   * Test- Crea action di Default
   */
  @Test
  public void DefaultTest(){
    Action test = paf.create("");
    assertEquals(test.getClass(),WelcomeAction.class);
  }


}
