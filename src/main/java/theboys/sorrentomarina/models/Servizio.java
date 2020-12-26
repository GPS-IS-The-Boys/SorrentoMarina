package theboys.sorrentomarina.models;

import lombok.Getter;
import lombok.Setter;

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

  public Servizio() { super(); }

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

  public Servizio(boolean bar, boolean ristorante, boolean animazione, boolean wifi, boolean cabina, boolean beach_volley, boolean canoa) {
    this.bar = bar;
    this.ristorante = ristorante;
    this.animazione = animazione;
    this.wifi = wifi;
    this.cabina = cabina;
    this.beach_volley = beach_volley;
    this.canoa = canoa;
  }
}
