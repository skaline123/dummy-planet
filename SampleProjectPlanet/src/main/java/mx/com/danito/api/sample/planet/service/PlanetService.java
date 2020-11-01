/**
 * 
 */
package mx.com.danito.api.sample.planet.service;

import java.io.IOException;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import mx.com.danito.api.sample.planet.bean.ProcessBean;
import mx.com.danito.api.sample.planet.exception.BlogicException;
import mx.com.danito.api.sample.planet.facade.PlanetFacade;
import mx.com.danito.api.sample.planet.util.Util;

/**
 * @author danito
 *
 */
@Service
public class PlanetService {

	private final static Logger LOGGER = LogManager.getLogger(PlanetService.class);

	ProcessBean pmbean = null;

	public void masterProcess(String... args) throws BlogicException, IOException {
		LOGGER.log(Level.INFO, "process PlanetService --- masterProcess ******************");
		
		if (args.length > 0) {
			pmbean = new ProcessBean();
			pmbean = Util.validMenuExist(args, pmbean);
		
			if (pmbean.getMenu() != null) {
				
				if(pmbean.isValidator()) {
					if(pmbean.getMenu().getId().equals("MENU_PROCESS_FILE_CSV")) {
						
						new PlanetFacade().processFileCsv(pmbean);
						
					} else if(pmbean.getMenu().getId().equals("MENU_PROCESS_FILE_ASCII")) {
						
						new PlanetFacade().processFileAscii(pmbean);
						
					} else if(pmbean.getMenu().getId().equals("MENU_PROCESS_ALL")) {
						
						new PlanetFacade().processFileCsv(pmbean);
						new PlanetFacade().processFileAscii(pmbean);
						
					}
					
					//here maybe we can send output to email

					
				} else {
					LOGGER.log(Level.INFO, "The process or the order by is not exist ... ");
				}
				
			} else {
				LOGGER.log(Level.INFO, "The process is not exist ... ");
			}
		} else {
			LOGGER.log(Level.INFO, "Is necesary especifict menu parameter ... ");
		}

	}

}
