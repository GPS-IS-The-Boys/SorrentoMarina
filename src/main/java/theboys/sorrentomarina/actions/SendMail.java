package theboys.sorrentomarina.actions;

import org.apache.commons.mail.*;

public class SendMail {

  private String oggetto;
  private String msg;
  private String dest;
  private static final String mittente = "ConsorzioSorrentoMarina@gmail.com";

  public SendMail(String oggetto, String msg, String dest) {
    this.oggetto = oggetto;
    this.msg = msg;
    this.dest = dest;
  }

  public void send() throws EmailException {

    Email email = new SimpleEmail();
    email.setHostName("smtp.gmail.com");
    email.setSmtpPort(465);
    email.setAuthenticator(new DefaultAuthenticator("ConsorzioSorrentoMarina@gmail.com","SorrentoMarina0@"));
    email.setSSLOnConnect(true);
    email.setFrom(mittente);
    email.setSubject(oggetto);
    email.setMsg(msg);
    email.addTo(dest);
    email.setStartTLSEnabled(true);
    email.send();

  }
}
