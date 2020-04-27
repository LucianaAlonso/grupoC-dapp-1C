package services;

import builders.ComercioBuilder;
import com.example.demo.repositories.IStoreRepository;
import com.example.demo.services.IStoreService;
import com.example.demo.services.StoreService;
import model.Comercio;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class StoreServiceTest {

    @Mock
    IStoreRepository storeRepositoryMock;

    @InjectMocks
    @Qualifier("storeService")
    IStoreService storeService = new StoreService();

    @Test
    public void whenWeAskStoreServiceForStoresItReturnsTheListOfActualStores() {
        List<Comercio> stores = ComercioBuilder.storeList();
        when(storeRepositoryMock.getStores()).thenReturn(stores);

        assertEquals(stores, storeService.getStores());
    }
}
