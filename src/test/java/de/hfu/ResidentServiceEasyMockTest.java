package de.hfu;

import de.hfu.residents.domain.Resident;
import de.hfu.residents.repository.ResidentRepository;
import de.hfu.residents.service.BaseResidentService;
import de.hfu.residents.service.ResidentService;
import de.hfu.residents.service.ResidentServiceException;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.easymock.EasyMock.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class ResidentServiceEasyMockTest {

    @Test
    public void test() throws ResidentServiceException {

        Resident resident1 = new Resident("David","Geigle","...","Furtwangen", new GregorianCalendar(1998, Calendar.JUNE,1).getTime());
        Resident resident2 = new Resident("Theresa","Geigle","XYZ","Wildberg", new GregorianCalendar(2000, Calendar.AUGUST,15).getTime());
        Resident resident3 = new Resident("Bob","Reynolds","Bahnhofsstraße","Furtwangen", new GregorianCalendar(2002,Calendar.JANUARY,22).getTime());

        ArrayList testList = new ArrayList<Resident>();

        testList.add(resident1);
        testList.add(resident2);
        testList.add(resident3);

        ResidentRepository residentRepositoryMock = createMock(ResidentRepository.class);
        expect(residentRepositoryMock.getResidents()).andReturn(testList);

        replay(residentRepositoryMock);


        //gen Service
        BaseResidentService baseResidentService = new BaseResidentService();
        baseResidentService.setResidentRepository(residentRepositoryMock);

        //set Filter
        Resident filterResident = new Resident();
        filterResident.setGivenName("David");

        //use Filter
        assertThat(baseResidentService.getUniqueResident(filterResident), equalTo(resident1));

        verify(residentRepositoryMock);
    }
}
