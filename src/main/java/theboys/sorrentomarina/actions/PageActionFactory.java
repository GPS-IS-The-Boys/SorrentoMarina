package theboys.sorrentomarina.actions;

import theboys.sorrentomarina.actions.account.AuthorizeAdminAction;


/**
 *
 * @author Diequ
 */
public class PageActionFactory implements ActionFactory {
    
    //private static final UnauthorizedAction UN_ACTION = new UnauthorizedAction();
    //private static final AuthorizeAdminAction AA_ACTION = new AuthorizeAdminAction();

    @Override
    public Action create(String type) {
        switch(type){
            case "AdminDashboard":
               return new ShowDashboardAction();
            default:
                return new WelcomeAction();
        }
    }
    
}
