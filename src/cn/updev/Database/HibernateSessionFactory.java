package cn.updev.Database;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

/**
 * Created by hypo on 15-11-17.
 */
public class HibernateSessionFactory {

    private static String CONFIG_FILE_LOCATION = "hibernate.cfg.xml";

    /** Holds a single instance of Session */
    private static final ThreadLocal threadLocal = new ThreadLocal();

    /** The single instance of hibernate configuration */
    private static final Configuration cfg = new Configuration();

    /** The single instance of hibernate SessionFactory */
    private static org.hibernate.SessionFactory sessionFactory;

    /** Log4j */
    private static Logger logger = Logger.getLogger(HibernateSessionFactory.class);

    /**
     * Returns the ThreadLocal Session instance. Lazy initialize
     * the SessionFactory if needed.
     *
     * @return Session
     * @throws HibernateException
     */

    public static Session currentSession() throws HibernateException {
        Session session = (Session) threadLocal.get();

        if (session == null) {
            if (sessionFactory == null) {
                try {
                    cfg.configure(CONFIG_FILE_LOCATION);
                    sessionFactory = cfg.buildSessionFactory();
                }
                catch (Exception e) {
                    logger.error("获得SessionFactory失败!");
                    e.printStackTrace();
                }
            }
            session = sessionFactory.openSession();
            threadLocal.set(session);
        }

        return session;
    }

    /**
     * Close the single hibernate session instance.
     *
     * @throws HibernateException
     */
    public static void closeSession() throws HibernateException {
        Session session = (Session) threadLocal.get();
        threadLocal.set(null);

        if (session != null) {
            session.close();
        }
    }

    /**
     * Default constructor.
     */
    private HibernateSessionFactory() {
    }

}
