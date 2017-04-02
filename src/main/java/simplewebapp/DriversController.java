package simplewebapp;

import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

@RestController
public class DriversController {

	@Autowired
	DriversRepository repository;
	
	@RequestMapping(value="/driver", method=RequestMethod.GET)
	public Optional<Driver> findById(@RequestParam("id") int id){
		Optional<Driver> driver = null;
		driver = repository.findById(id);
		return driver;
	}

	
    @RequestMapping(value="/import", method=RequestMethod.POST)
    @ResponseBody
    public boolean addDriversJson(){
    	
    	boolean isDriverAdded = true;
    	
		File inputFile = new File( "drivers.json" );
		try {
			Reader reader = new FileReader( inputFile );
			JsonParser parser = new JsonParser();
			JsonArray jsonArray = parser.parse( reader ).getAsJsonArray();
			for ( int i = 0 ; i < jsonArray.size() ; i++ ) {
				JsonObject currDriverLine = jsonArray.get( i ).getAsJsonObject();
				JsonElement driverId = currDriverLine.get("id");
				JsonElement driverName = currDriverLine.get("name");
				JsonElement driverLicenseNumber = currDriverLine.get("license_number");
				
				Driver driver = new Driver(driverId.getAsInt(), driverName.getAsString(), driverLicenseNumber.getAsString());
		    	repository.save(driver);
			}
			
		} catch ( Exception e ) {
			isDriverAdded = false;
			e.printStackTrace();
		}

    	return isDriverAdded;
    }
    	
	
}
