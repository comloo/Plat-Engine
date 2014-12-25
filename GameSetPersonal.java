/**
 * Stores the game set of the program.
 * This class has get and set methods as well as methods used for formatting the data.
 * 
 * @author Simon Yuan
 * @version 1.0, May 16, 2014     
 */
public class GameSetPersonal{
  /**
   * @param gameName String stores the game name.
   * @param gameIntro String stores the game introduction.
   * @param releaseDateY Int stores the year of the game released 
   * @param releaseDateM Int stores the month of the game released.
   * @param releaseDateD Int stores the day of the game released.
   * @param gameSize String stores the game'size.
   * @param gameCompany String stores the game company.
   */ 
  private String gameName, gameIntro,releaseDateY,releaseDateM,releaseDateD, gameSize, gameCompany,genre;
  
  public static int numRecords=0;
  /**
   * A class constructor with seven parameters to pass through.
   */ 
  public GameSetPersonal (String gameName,String gameCompany,String releaseDateY,String releaseDateM,String releaseDateD, String gameSize,String genre,String gameIntro){
    this.gameName = formatGameName (gameName);
    this.gameIntro = gameIntro;
    this.genre = genre;
    this.releaseDateY = releaseDateY;
    this.releaseDateM = releaseDateM;
    this.releaseDateD = releaseDateD;
    this.gameSize = gameSize;
    this.gameCompany = formatGameName(gameCompany);
    numRecords+=1;
  }
  /**
   * A class constructor with six parameters to pass through.
   */ 
  public GameSetPersonal (String genre,String gameName,String gameIntro,String releaseDateY,String releaseDateM,String releaseDateD, String gameSize){
    this.gameName = formatGameName (gameName);
    this.gameIntro = gameIntro;
    this.genre = genre;
    this.releaseDateY = releaseDateY;
    this.releaseDateM = releaseDateM;
    this.releaseDateD = releaseDateD;
    this.gameSize = gameSize;
        numRecords+=1;
  }
  /**
   * A class constructor with five parameters to pass through.
   */ 
  public GameSetPersonal (String genre,String gameName,String gameIntro,String releaseDateY,String releaseDateM,String releaseDateD){
    this.gameName = formatGameName (gameName);
    this.gameIntro = gameIntro;
    this.genre = genre;
    this.releaseDateY = releaseDateY;
    this.releaseDateM = releaseDateM;
    this.releaseDateD = releaseDateD;
        numRecords+=1;
  }
  /**
   * A class constructor with four parameters to pass through.
   */ 
  public GameSetPersonal (String genre,String gameName,String gameIntro,String releaseDateY,String releaseDateM){
    this.gameName = formatGameName (gameName);
    this.gameIntro = gameIntro;
    this.genre = genre;
    this.releaseDateY = releaseDateY;
    this.releaseDateM = releaseDateM;
        numRecords+=1;
  }
  /**
   * A class constructor with three parameters to pass through.
   */ 
  public GameSetPersonal (String genre,String gameName,String gameIntro,String releaseDateY){
    this.gameName = formatGameName (gameName);
    this.gameIntro = gameIntro;
    this.genre = genre;
    this.releaseDateY = releaseDateY;
        numRecords+=1;
  }  
  /**
   * A class constructor with two parameters to pass through.
   */ 
  public GameSetPersonal (String genre,String gameName,String gameIntro){
    this.gameName = formatGameName (gameName);
    this.gameIntro = gameIntro;
    this.genre = genre;
        numRecords+=1;
  }
  /**
   * A class constructor with one parameter to pass through.
   */ 
  public GameSetPersonal (String genre,String gameName){
    this.gameName = formatGameName (gameName);
    this.genre = genre;
    numRecords+=1;
  }
  /**
   * A class constructor with no parameter to pass through.
   */ 
  public GameSetPersonal (String genre){
    this.genre = genre;
        numRecords+=1;
  }
  public GameSetPersonal (){
        numRecords+=1;
  }
  /**
   * The setGameName method passes a string through to be formatted and set.
   * 
   * @param newGameName creates a new string parameter.
   */
  public void setGenre (String newGenre){
    genre = newGenre ;
  }
  public void setGameName (String newGameName)
  {
    gameName = formatGameName (newGameName);
  }
  /**
   * The setGameIntro method passes a string through to be formatted and set.
   * 
   * @param newGameIntro creates a new string parameter.
   */
  public void setGameIntro (String newGameIntro)
  {
    gameIntro = newGameIntro; 
  }
  /**
   * The setReleaseDateY method passes a string through to be formatted and set.
   * 
   * @param newReleaseDateY creates a new string parameter.
   */
  public void setReleaseDateY (String newReleaseDateY)
  {
    releaseDateY = newReleaseDateY;
  }
  /**
   * The setReleaseDateM method passes a string through to be formatted and set.
   * 
   * @param newReleaseDateM creates a new string parameter.
   */
  public void setReleaseDateM (String newReleaseDateM)
  {
    releaseDateM = newReleaseDateM; 
  }
  /**
   * The setReleaseDateD method passes a string through to be formatted and set.
   * 
   * @param newReleaseDateD creates a new string parameter.
   */
  public void setReleaseDateD (String newReleaseDateD){
    releaseDateD = newReleaseDateD;
  }
  /**
   * The setGameSize method passes a string through to be formatted and set.
   * 
   * @param newGameSize creates a new string parameter.
   */
  public void setGameSize (String newGameSize){
    gameSize = newGameSize;
  }
  /**
   * The setGameCompany method passes a string through to be formatted and set.
   * 
   * @param newGameCompany creates a new string parameter.
   */
  public void setGameCompany (String newGameCompany){
    gameCompany = formatGameName(newGameCompany);
  }
  /**
   * The getGameName method passes a string through to be returned.
   */
  public String getGameName (){
    return gameName == "" ? "Name" : gameName;
  }
  /**
   * The getGameIntro method passes a string through to be returned.
   */
  public String getGameIntro (){
    return gameIntro ; 
  }
  /**
   * The getSetReleaseDateY method passes a string through to be returned.
   */
  public String getReleaseDateY (){
    return releaseDateY ;
  }
  /**
   * The getSetReleaseDataM method passes a string through to be returned.
   */
  public String getReleaseDateM (){
    return releaseDateM; 
  }
  /**
   * The getReleaseDataD method passes a string through to be returned.
   */
  public String getReleaseDateD (){
    return releaseDateD ;
  }
  /**
   * The getGameSize method passes a string through to be returned.
   */
  public String getGameSize (){
    return gameSize;
  }
  /**
   * The getGameCompany method passes a string through to be returned.
   */
  public String getGameCompany (){
    return gameCompany ;
  }
  public String getGenre (){
    return genre;
  }
  /**
   * The formatGameName method passes a string through to be formatted correctly.
   * 
   * @param gameN creates a new String parameter to be formatted and returned.
   */
  private String formatGameName (String gameN)
  {
    if (gameN == null || gameN.equals (""))
    {
      return "";
    }
    else
    {
      return (gameN.substring(0,1).toUpperCase() + gameN.substring (1).toLowerCase());
    }
  }
}