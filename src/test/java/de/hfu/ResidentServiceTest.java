package de.hfu;

import de.hfu.residents.domain.Resident;
import de.hfu.residents.repository.ResidendRepositoryStub;
import de.hfu.residents.repository.ResidentRepository;
import de.hfu.residents.service.BaseResidentService;
import de.hfu.residents.service.ResidentService;
import de.hfu.residents.service.ResidentServiceException;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import static org.junit.Assert.*;

public class ResidentServiceTest {

    @Test
    public void testGetUniqueResident(){
        ResidendRepositoryStub testRepository = new ResidendRepositoryStub();

        Resident resident1 = new Resident("David","Geigle","...","Furtwangen", new GregorianCalendar(1998, Calendar.JUNE,1).getTime());
        Resident resident2 = new Resident("Theresa","Geigle","XYZ","Wildberg", new GregorianCalendar(2000, Calendar.AUGUST,15).getTime());
        Resident resident3 = new Resident("Bob","Reynolds","Bahnhofsstraße","Furtwangen", new GregorianCalendar(2002,Calendar.JANUARY,22).getTime());

        testRepository.add(resident1);
        testRepository.add(resident2);
        testRepository.add(resident3);

        BaseResidentService service = new BaseResidentService();
        service.setResidentRepository(testRepository);

        Resident filterResident = new Resident();
        filterResident.setGivenName("David");

        try {
            assertEquals(resident1,service.getUniqueResident(filterResident));
        } catch (ResidentServiceException e) {
            assert false;
        }
    }

    @Test(expected = ResidentServiceException.class)
    public void testGetUniqueResidentException(){
        ResidendRepositoryStub testRepository = new ResidendRepositoryStub();

        Resident resident1 = new Resident("David","Geigle","...","Furtwangen", new GregorianCalendar(1998, Calendar.JUNE,1).getTime());
        Resident resident2 = new Resident("Theresa","Geigle","XYZ","Wildberg", new GregorianCalendar(2000, Calendar.AUGUST,15).getTime());
        Resident resident3 = new Resident("Bob","Reynolds","Bahnhofsstraße","Furtwangen", new GregorianCalendar(2002,Calendar.JANUARY,22).getTime());

        testRepository.add(resident1);
        testRepository.add(resident2);
        testRepository.add(resident3);

        BaseResidentService service = new BaseResidentService();
        service.setResidentRepository(testRepository);

        Resident filterResident = new Resident();
        filterResident.setGivenName("*");
    }

}
