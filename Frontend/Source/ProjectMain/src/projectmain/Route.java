package projectmain;

public class Route {
    private Object[] columnTitles;

    private Object[][] data;

    Route()
    {
        Object[] fetchColumnTitles = {
            "Driver",
            "Truck ID",
            "Shipping content",
            "Transportation Status"
        };


        Object[][] fetchData = {
            {"Vasilis", new Integer(100), "shippment 1-10", "Ready"},
            {"Andreas", new Integer(101), "shippment 11-14", "Transporting..."},
            {"Tasos", new Integer(120), "shippment 15-20", "Shipped"},
            {"Kostas", new Integer(130), "shippment 21-26", "Loading Truck..."},
            {"Vaggelis", new Integer(112), "shippment 27-36", "Transporting..."},
            {"Xrhstos", new Integer(112), "shippment 27-36", "Shipped"},
            {"Vaggelis", new Integer(112), "shippment 27-36", "Transporting..."},
            {"Vaggelis", new Integer(112), "shippment 27-36", "Transporting..."},
            {"Vaggelis", new Integer(112), "shippment 27-36", "Transporting..."},
            {"Vaggelis", new Integer(112), "shippment 27-36", "Transporting..."},
            {"Vaggelis", new Integer(112), "shippment 27-36", "Transporting..."},
            {"Vaggelis", new Integer(112), "shippment 27-36", "Transporting..."},
            {"Vaggelis", new Integer(112), "shippment 27-36", "Transporting..."},
            {"Vaggelis", new Integer(112), "shippment 27-36", "Transporting..."},
            {"Vaggelis", new Integer(112), "shippment 27-36", "Transporting..."},
            {"Vaggelis", new Integer(112), "shippment 27-36", "Transporting..."},
            {"Vaggelis", new Integer(112), "shippment 27-36", "Transporting..."},
            {"Vaggelis", new Integer(112), "shippment 27-36", "Transporting..."},
            {"Vaggelis", new Integer(112), "shippment 27-36", "Transporting..."},
            {"Vaggelis", new Integer(112), "shippment 27-36", "Transporting..."},
            {"Vaggelis", new Integer(112), "shippment 27-36", "Transporting..."},
            {"Vaggelis", new Integer(112), "shippment 27-36", "Transporting..."},
            {"Vaggelis", new Integer(112), "shippment 27-36", "Transporting..."},
            {"Vaggelis", new Integer(112), "shippment 27-36", "Transporting..."},
            {"Vaggelis", new Integer(112), "shippment 27-36", "Transporting..."},
            {"Vaggelis", new Integer(112), "shippment 27-36", "Transporting..."},
            {"Vaggelis", new Integer(112), "shippment 27-36", "Transporting..."},
            {"Vaggelis", new Integer(112), "shippment 27-36", "Transporting..."},
            {"Vaggelis", new Integer(112), "shippment 27-36", "Transporting..."},
            {"Vaggelis", new Integer(112), "shippment 27-36", "Transporting..."},
            {"Vaggelis", new Integer(112), "shippment 27-36", "Transporting..."},
            {"Kostas", new Integer(112), "shippment 27-36", "Transporting..."},
        };

        columnTitles = fetchColumnTitles;
        data = fetchData;
    }
    public Object[] getColumnTitles()
    {
        return columnTitles;
    }

    public Object[][] getData()
    {
        return data;
    }
}
