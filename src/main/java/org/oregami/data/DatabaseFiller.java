package org.oregami.data;

import org.oregami.entities.Game;
import org.oregami.entities.GameTitle;
import org.oregami.entities.KeyObjects.SystemKey;
import org.oregami.entities.ReleaseGroupType;
import org.oregami.entities.ReleaseGroup;

import com.google.inject.Inject;
import com.google.inject.persist.Transactional;

/**
 * Class to fill the database with some sample entities.
 * 
 * @author twendelmuth
 * 
 */
public class DatabaseFiller {

	@Inject 
	private GameDao gameRepository;

	@Inject
	private ReleaseGroupTypeDao rgtRepository;

	private void addReleaseGroupTypes() {		
		rgtRepository.save(new ReleaseGroupType("Original"));
		rgtRepository.save(new ReleaseGroupType("Enhanced"));
		rgtRepository.save(new ReleaseGroupType("Demo"));
		rgtRepository.save(new ReleaseGroupType("Remake"));
	}

	private void addMonkeyIsland() {
		Game gameMonkeyIsland = new Game();
		
		gameMonkeyIsland.addGameTitle(new GameTitle("Monkey Island"));
		gameMonkeyIsland.addGameTitle(new GameTitle("Monkey Island 1"));
		gameMonkeyIsland.addGameTitle(new GameTitle("The Secret of Monkey Island"));

		ReleaseGroup releaseGroupDos = new ReleaseGroup("DOS", SystemKey.MSDOS, rgtRepository.findByName("Original"));
		ReleaseGroup releaseGroupDosDemo = new ReleaseGroup("DOS", SystemKey.MSDOS, rgtRepository.findByName("Demo"));
		ReleaseGroup releaseGroupDosEnhanced = new ReleaseGroup("DOS (Verbesserte CD-Version)", SystemKey.MSDOS, rgtRepository.findByName("Enhanced"));

		gameMonkeyIsland.addReleaseGroup(releaseGroupDos);
		gameMonkeyIsland.addReleaseGroup(releaseGroupDosDemo);
		gameMonkeyIsland.addReleaseGroup(releaseGroupDosEnhanced);

		// ########### Amiga
		ReleaseGroup releaseGroupAmiga = new ReleaseGroup("Amiga 500/600 (OCS/ECS)", SystemKey.Amiga, rgtRepository.findByName("Original"));
		ReleaseGroup releaseGroupAmigaDemo = new ReleaseGroup("Amiga 500/600 (OCS/ECS)", SystemKey.Amiga, rgtRepository.findByName("Demo"));

		gameMonkeyIsland.addReleaseGroup(releaseGroupAmiga);
		gameMonkeyIsland.addReleaseGroup(releaseGroupAmigaDemo);

		// ########### Atari ST
		ReleaseGroup releaseGroupAtariST = new ReleaseGroup("Atari ST", SystemKey.AtariST, rgtRepository.findByName("Original"));
		gameMonkeyIsland.addReleaseGroup(releaseGroupAtariST);

		// ########### Apple
		ReleaseGroup releaseGroupApple = new ReleaseGroup("Apple Macintosh", SystemKey.AppleMacintosh, rgtRepository.findByName("Original"));
		ReleaseGroup vogAppleSpecial = new ReleaseGroup("Apple Macintosh", SystemKey.AppleMacintosh, rgtRepository.findByName("Enhanced"));

		gameMonkeyIsland.addReleaseGroup(releaseGroupApple);
		gameMonkeyIsland.addReleaseGroup(vogAppleSpecial);

		gameRepository.save(gameMonkeyIsland);
		
		gameRepository.update(gameMonkeyIsland);
	}

	private void addResidentEvilGame() {

		Game gameResidentEvil = new Game();
		// gameResidentEvil.setId(2l);

		gameResidentEvil.addGameTitle(new GameTitle("Resident Evil"));

		ReleaseGroup releaseGroupPlaystation = new ReleaseGroup("Playstation", SystemKey.Playstation, rgtRepository.findByName("Original"));
		gameResidentEvil.addReleaseGroup(releaseGroupPlaystation);
		ReleaseGroup releaseGroupWindows = new ReleaseGroup("Windows", SystemKey.Windows, rgtRepository.findByName("Original"));
		gameResidentEvil.addReleaseGroup(releaseGroupWindows);

		gameRepository.save(gameResidentEvil);
	}

	private void addXWingGame() {
		Game gameXWing = new Game();

		gameXWing.addGameTitle(new GameTitle("Star Wars - X-Wing"));
		gameXWing.addGameTitle(new GameTitle("Star Wars - X-Wing: Space Combat Simulator"));

		ReleaseGroup rgDos = new ReleaseGroup("DOS", SystemKey.MSDOS, rgtRepository.findByName("Original"));
		gameXWing.addReleaseGroup(rgDos);

		ReleaseGroup rgDosEnhanced = new ReleaseGroup("DOS", SystemKey.MSDOS, rgtRepository.findByName("Enhanced"));
		gameXWing.addReleaseGroup(rgDosEnhanced);

		ReleaseGroup rgWinEnhanced = new ReleaseGroup("Windows", SystemKey.Windows, rgtRepository.findByName("Enhanced"));
		gameXWing.addReleaseGroup(rgWinEnhanced);

		ReleaseGroup rgMacEnhanced = new ReleaseGroup("Apple Macintosh", SystemKey.AppleMacintosh, rgtRepository.findByName("Enhanced"));
		gameXWing.addReleaseGroup(rgMacEnhanced);

		gameRepository.save(gameXWing);
	}

	private void addGames() {
		
		if (gameRepository.findOne(1L)!=null) return;
		
		addReleaseGroupTypes();
		addMonkeyIsland();
		addResidentEvilGame();
		addXWingGame();
		
	}
	
	@Transactional
	public void initData() {
		addGames();
//		addVideoGamesDatabase1991();
//		addVideoGamesDatabase1992();
//		addVideoGamesDatabase1993();
	}
	


}
