package fa.training.consts;

public interface ApiPath {

    String API = "/api/v1";

    //ping
    String PING  = API + "/ping";

    //Customer
    String CUSTOMER_GET_ALL = API + "/customers";
    String CUSTOMER_CREATE = API + "/customer/create";
    String CUSTOMER_DELETE = API + "/customer/delete";
    String CUSTOMER_UPDATE = API + "/customer/update";
    String CUSTOMER_BY_ID = API + "/customer/{id}";

    //CartItems
    String CARTITEMS_GET_ALL = API + "/cartItems";
    String CARTITEMS_CREATE = API + "/cartItems/create";
    String CARTITEMS_DELETE = API + "/cartItems/delete";
    String CARTITEMS_UPDATE = API + "/cartItems/update";
    String CARTITEMS_BY_ID = API + "/cartItems/{id}";

    //Currencies
    String CURRENCIES_GET_ALL = API + "/currencies";
    String CURRENCIES_CREATE = API + "/currencies/create";
    String CURRENCIES_DELETE = API + "/currencies/delete";
    String CURRENCIES_UPDATE = API + "/currencies/update";
    String CURRENCIES_BY_ID = API + "/currencies/{id}";

    //CartItems
    String NOTIFICATION_GET_ALL = API + "/notifications";
    String NOTIFICATION_CREATE = API + "/notification/create";
    String NOTIFICATION_DELETE = API + "/notification/delete";
    String NOTIFICATION_UPDATE = API + "/notification/update";
    String NOTIFICATION_BY_ID = API + "/notification/{id}";
}
