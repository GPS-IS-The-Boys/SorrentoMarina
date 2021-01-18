package theboys.sorrentomarina.actions.actionsPrenotazione;

import org.apache.commons.mail.*;
/**
 * @author theboys
 */
public class SendMail {

  private String oggetto;
  private String msg;
  private String dest;
  private static final String MITTENTE = "ConsorzioSorrentoMarina@gmail.com";


  public SendMail(String oggetto, String msg, String dest) {
    this.oggetto = oggetto;
    this.msg = msg;
    this.dest = dest;
  }

  /**
   * Invia una E-mail
   *
   * @throws EmailException
   */
  public void send() throws EmailException {

    Email email = new SimpleEmail();
    email.setHostName("smtp.gmail.com");
    email.setSmtpPort(465);
    email.setAuthenticator(new DefaultAuthenticator("ConsorzioSorrentoMarina@gmail.com",
        "SorrentoMarina0@"));
    email.setSSLOnConnect(true);
    email.setFrom(MITTENTE);
    email.setSubject(oggetto);
    email.setMsg(msg);
    email.addTo(dest);
    email.setStartTLSEnabled(true);
    email.getMailSession().getProperties().put("mail.smtp.ssl.trust", "smtp.gmail.com");
    email.send();

  }
}
