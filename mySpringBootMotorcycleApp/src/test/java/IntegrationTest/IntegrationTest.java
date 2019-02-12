package IntegrationTest;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.parsons.elliott.springboot.motorcycle.mySpringBootMotorcycleApp.MySpringBootMotorcycleAppApplication;
import com.parsons.elliott.springboot.motorcycle.mySpringBootMotorcycleApp.model.MySpringBootMotorcycleModel;
import com.parsons.elliott.springboot.motorcycle.mySpringBootMotorcycleApp.repository.MySpringBootMotorcycleRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(classes= {MySpringBootMotorcycleAppApplication.class})
@ContextConfiguration(classes= {MySpringBootMotorcycleAppApplication.class})
@AutoConfigureMockMvc

public class IntegrationTest {
	
	@Autowired
	private MockMvc mvc;
	
	@Autowired
	private MySpringBootMotorcycleRepository repository;
	
	@Before
	public void clearDB() {
		repository.deleteAll();
	}
	
	@After
	public void afterDB() {
		repository.deleteAll();
	}
	
	@Test
	public void addAMotorcycleToDatabaseTest()
		throws Exception{
		mvc.perform(MockMvcRequestBuilders.post("/api/create/motorcycle")
			.contentType(MediaType.APPLICATION_JSON)
			.content("{\"manufacturer\" : \"Yamaha\",\"model\" : \"testModel\", \"displacement\" : \"345\" , \"category\": \"testCategory\" , \"horsepower\": \"testHorsepower\" , \"price\": \"123\" , \"license\": \"CBT\"}"))
			.andExpect(status()
			.isOk())
			.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
			.andExpect(jsonPath("$.model", is("testModel")));  
	}  
	
	@Test
	public void deleteAllMotorcyclesFromDatabase()
		throws Exception {
		
		MySpringBootMotorcycleModel motorcycle = new MySpringBootMotorcycleModel(3, "testMan","testMod","testDis","testCat","testHors",123,"testLic");
		
		repository.save(motorcycle);
		mvc.perform(MockMvcRequestBuilders.delete("/api/delete/all/motorcycles")
			.contentType(MediaType.APPLICATION_JSON))
        	.andExpect(status()
        	.isOk());      
	}
	
	@Test
	public void findAllMotorcycleFromDatabase()
		throws Exception {
		 
		MySpringBootMotorcycleModel motorcycle = new MySpringBootMotorcycleModel(1, "testMan","testMod","testDis","testCat","testHors",123,"testLic");
		MySpringBootMotorcycleModel motorcycle1 = new MySpringBootMotorcycleModel(2, "testMan1","testMod1","testDis1","testCat1","testHors1",123,"testLic1");
		
		repository.save(motorcycle);
		repository.save(motorcycle1);
		mvc.perform(get("/api/get/all/motorcycles")
    		.contentType(MediaType.APPLICATION_JSON))
    		.andExpect(status() 
    		.isOk())  
			.andExpect(content()  
			.contentTypeCompatibleWith(MediaType.APPLICATION_JSON)) 
			.andExpect(jsonPath("$[0].model",is("testMod")))
			.andExpect(jsonPath("$[1].model", is("testMod1")));
    }  	

}
