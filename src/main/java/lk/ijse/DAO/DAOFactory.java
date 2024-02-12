package lk.ijse.DAO;

import lk.ijse.DAO.Custom.Impl.StudentDaoImpl;

public class DAOFactory {
    private static DAOFactory daoFactory;

    private DAOFactory() {
    }

    public static DAOFactory getDaoFactory() {
        return (daoFactory == null) ? daoFactory = new DAOFactory() : daoFactory;
    }

    public enum DAOTypes {
        STUDENT
    }

    public SuperDao getDAO(DAOTypes types){
        switch (types) {
            case STUDENT:
                return new StudentDaoImpl();
            default:
                return null;
        }
    }
}
