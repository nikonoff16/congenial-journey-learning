import java.util.Arrays;
import java.util.logging.*;

/**
 * Created by kvu on 16.08.2017.
 */
public class Solution {
    /**
     * проверка почтовой машины к уроку 4.9
     */

    /**
     * Здесь пишите Ваш код
     *              *
     *              *
     *            ******
     *             ****
     * *            **
     */
    //Stepik code: start

    // Ненадёжный сотрудник
    public static class UntrustworthyMailWorker implements MailService {
        private static MailService[] workers;
        private static RealMailService realWorker = new RealMailService();
        
        public UntrustworthyMailWorker (MailService[] w){
            workers = w;
        }
        
        public MailService getRealMailService() {
            return realWorker;
        }
        
        @Override
        public Sendable processMail(Sendable mail) {
            for (MailService worker : workers) {
                mail = worker.processMail(mail);
            }
            Sendable realService = realWorker.processMail(mail);
            return realService;
        }
    }

    // Вор
    public static class Thief implements MailService {
        private static int stolenValue;
        private static int minValue;

        public Thief(int value) {
            minValue = value;
        }

        public int getStolenValue() {
            return stolenValue;
        }

        @Override
        public Sendable processMail(Sendable mail) {
            Sendable result;
            if (mail instanceof MailPackage) {
                MailPackage realMail = (MailPackage) mail;
                String sender = mail.getFrom();
                String receiver = mail.getTo();
                Package realPackage = realMail.getContent();

                if (realPackage.getPrice() >= minValue) {
                    Package stolenPackage = new Package("stones instead of " + realPackage.getContent() , 0);
                    stolenValue += realPackage.getPrice();
                    MailPackage fackedMail = new MailPackage(sender, receiver, stolenPackage);

                    result = fackedMail;

                } else {
                    result = mail;
                }
            } else {
                result = mail;
            }
            return result;
        }
    }
    
    // Шпион
    public static class Spy implements MailService {
        private final Logger LOGGER;

        public Spy(Logger logger) {
            this.LOGGER = logger;     
         }

        @Override
        public Sendable processMail(Sendable mail) {
            if (mail instanceof MailMessage) {
                MailMessage realMessage = (MailMessage) mail;
                if (realMessage.from == AUSTIN_POWERS || realMessage.to == AUSTIN_POWERS) {
                    String importantSpyMessage = "Detected target mail correspondence: from " + realMessage.from + " to " + realMessage.to + " \"" + realMessage.getMessage() + "\"";
                    this.LOGGER.log(Level.WARNING, importantSpyMessage);
                } else {
                    String usualSpyMessage = "Usual correspondence: from " + realMessage.from + " to " + realMessage.to;
                    this.LOGGER.log(Level.INFO, usualSpyMessage);
                }
            }
            return mail;
        }
    }
    
    // Инспектор
    public static class Inspector implements MailService {
        
       @Override
       public Sendable processMail(Sendable mail) {
        if (mail instanceof MailPackage) {
            MailPackage realMail = (MailPackage) mail;
            String content = realMail.getContent().getContent();

            if (content.contains(WEAPONS) || content.contains(BANNED_SUBSTANCE)) {
                throw new IllegalPackageException();
            } else if (content.contains("stones")) {
                throw new StolenPackageException();
            }

        }
        return mail;
       }
    }

    
    // Блок исключений
    public static class IllegalPackageException extends RuntimeException {
        public IllegalPackageException() {
        }
        
        public IllegalPackageException (String message) {
        }
    }
    
    public static class StolenPackageException extends RuntimeException {
        public StolenPackageException() {
        }
        
        public StolenPackageException (String message) {
        }
    }
    ////Stepik code: end
    
    /**
     *              **
     *             ****
     *            ******
     *               *
     *               *
     * Запускать на исполнение класс main. он ниже.
     */

    public static final String AUSTIN_POWERS = "Austin Powers";
    public static final String WEAPONS = "weapons";
    public static final String BANNED_SUBSTANCE = "banned substance";

    public static void main(String[] args) {
        Logger logger = Logger.getLogger(Solution.class.getName());

        Inspector inspector = new Inspector();
        Spy spy = new Spy(logger);
        Thief thief = new Thief(10000);
        MailService variousWorkers[] = new MailService[]{spy, thief, inspector};
        UntrustworthyMailWorker worker = new UntrustworthyMailWorker(variousWorkers);

        AbstractSendable correspondence[] = {
                new MailMessage("Oxxxymiron", "Гнойный", "Я здесь чисто по фану, поглумиться над слабым\n" +
                        "Ты же вылез из мамы под мой дисс на Бабана...."),
                new MailMessage("Гнойный", "Oxxxymiron", "....Что? Так болел за Россию, что на нервах терял ганглии.\n" +
                        "Но когда тут проходили митинги, где ты сидел? В Англии!...."),
                new MailMessage("Жриновский", AUSTIN_POWERS, "Бери пацанов, и несите меня к воде."),
                new MailMessage(AUSTIN_POWERS, "Пацаны", "Го, потаскаем Вольфовича как Клеопатру"),
                new MailPackage("берег", "море", new Package("ВВЖ", 32)),
                new MailMessage("NASA", AUSTIN_POWERS, "Найди в России ракетные двигатели и лунные stones"),
                new MailPackage(AUSTIN_POWERS, "NASA", new Package("рпакетный двигатель ", 2500000)),
                new MailPackage(AUSTIN_POWERS, "NASA", new Package("stones", 1000)),
                new MailPackage("Китай", "КНДР", new Package("banned substance", 99)),
                new MailPackage(AUSTIN_POWERS, "ИГИЛ (запрещенная группировка", new Package("tiny bomb", 9000)),
                new MailMessage(AUSTIN_POWERS, "Психиатр", "Помогите"),
        };
        Arrays.stream(correspondence).forEach(parcell -> {
            try {
                worker.processMail(parcell);
            } catch (StolenPackageException e) {
                logger.log(Level.WARNING, "Inspector found stolen package: " + e);
            } catch (IllegalPackageException e) {
                logger.log(Level.WARNING, "Inspector found illegal package: " + e);
            }
        });
    }


    /*
    Интерфейс: сущность, которую можно отправить по почте.
    У такой сущности можно получить от кого и кому направляется письмо.
    */
    public interface Sendable {
        String getFrom();

        String getTo();
    }

    /*
Абстрактный класс,который позволяет абстрагировать логику хранения
источника и получателя письма в соответствующих полях класса.
*/
    public static abstract class AbstractSendable implements Sendable {

        protected final String from;
        protected final String to;

        public AbstractSendable(String from, String to) {
            this.from = from;
            this.to = to;
        }

        @Override
        public String getFrom() {
            return from;
        }

        @Override
        public String getTo() {
            return to;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            AbstractSendable that = (AbstractSendable) o;

            if (!from.equals(that.from)) return false;
            return to.equals(that.to);
        }

    }

    /*
Письмо, у которого есть текст, который можно получить с помощью метода `getMessage`
*/
    public static class MailMessage extends AbstractSendable {

        private final String message;

        public MailMessage(String from, String to, String message) {
            super(from, to);
            this.message = message;
        }

        public String getMessage() {
            return message;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            if (!super.equals(o)) return false;

            MailMessage that = (MailMessage) o;

            return message != null ? message.equals(that.message) : that.message == null;
        }

    }

    /*
Посылка, содержимое которой можно получить с помощью метода `getContent`
*/
    public static class MailPackage extends AbstractSendable {
        private final Package content;

        public MailPackage(String from, String to, Package content) {
            super(from, to);
            this.content = content;
        }

        public Package getContent() {
            return content;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            if (!super.equals(o)) return false;

            MailPackage that = (MailPackage) o;

            return content.equals(that.content);
        }

    }

    /*
Класс, который задает посылку. У посылки есть текстовое описание содержимого и целочисленная ценность.
*/
    public static class Package {
        private final String content;
        private final int price;

        public Package(String content, int price) {
            this.content = content;
            this.price = price;
        }

        public String getContent() {
            return content;
        }

        public int getPrice() {
            return price;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Package aPackage = (Package) o;

            if (price != aPackage.price) return false;
            return content.equals(aPackage.content);
        }
    }

    /*
Интерфейс, который задает класс, который может каким-либо образом обработать почтовый объект.
*/
    public interface MailService {
        Sendable processMail(Sendable mail);
    }

    /*
    Класс, в котором скрыта логика настоящей почты
    */
    public static class RealMailService implements MailService {

        @Override
        public Sendable processMail(Sendable mail) {
            // Здесь описан код настоящей системы отправки почты.
            return mail;
        }
    }

}