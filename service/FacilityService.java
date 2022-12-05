package service;

import java.io.IOException;

public interface FacilityService extends Service{
    void create() throws IOException;
    void displayMaintenance() throws IOException;
}
