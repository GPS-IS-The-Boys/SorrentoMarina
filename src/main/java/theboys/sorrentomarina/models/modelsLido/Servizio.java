package theboys.sorrentomarina.models.modelsLido;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
/**
 * @author theboys
 */
@Getter
@Setter
public class Servizio {
  private int id;
  private boolean bar;
  private boolean ristorante;
  private boolean animazione;
  private boolean wifi;
  private boolean cabina;
  private boolean beach_volley;
  private boolean canoa;

  /**
   * Costruttore di servizi vuoto
   */
  public Servizio() {
    super();
  }

  /**
   * Costruttore di servizi con parametri
   *
   * @param id
   * @param bar
   * @param ristorante
   * @param animazione
   * @param wifi
   * @param cabina
   * @param beach_volley
   * @param canoa
   */
  public Servizio(int id, boolean bar, boolean ristorante, boolean animazione, boolean wifi, boolean cabina, boolean beach_volley, boolean canoa) {
    this.id = id;
    this.bar = bar;
    this.ristorante = ristorante;
    this.animazione = animazione;
    this.wifi = wifi;
    this.cabina = cabina;
    this.beach_volley = beach_volley;
    this.canoa = canoa;
  }

  /**
   * Costruttore di sevizi con un unico valore
   * @param b
   */
  public Servizio(boolean b) {
    this.bar = b;
    this.ristorante = b;
    this.animazione = b;
    this.wifi = b;
    this.cabina = b;
    this.beach_volley = b;
    this.canoa = b;
  }

  /**
   * Costruttore di servizi con parametri escluso id
   *
   * @param bar
   * @param ristorante
   * @param animazione
   * @param wifi
   * @param cabina
   * @param beach_volley
   * @param canoa
   */
  public Servizio(boolean bar, boolean ristorante, boolean animazione, boolean wifi, boolean cabina, boolean beach_volley, boolean canoa) {
    this.bar = bar;
    this.ristorante = ristorante;
    this.animazione = animazione;
    this.wifi = wifi;
    this.cabina = cabina;
    this.beach_volley = beach_volley;
    this.canoa = canoa;
  }

  /**
   * Verifica che tutti i servizi siano settati a false
   *
   * @return boolean
   */
  public boolean isAllFalse() {
    if (!(this.bar || this.ristorante || this.animazione || this.wifi || this.cabina || this.beach_volley || this.canoa)) {
      return true;
    } else {
      return false;
    }
  }
}
