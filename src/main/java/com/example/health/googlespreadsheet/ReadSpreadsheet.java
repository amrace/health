/*
 * package com.example.health.googlespreadsheet;
 * 
 * import java.io.IOException; import java.net.URL;
 * 
 * import com.google.gdata.client.spreadsheet.SpreadsheetService; import
 * com.google.gdata.data.docs.SpreadsheetEntry; import
 * com.google.gdata.data.spreadsheet.ListEntry; import
 * com.google.gdata.data.spreadsheet.ListFeed; import
 * com.google.gdata.data.spreadsheet.WorksheetEntry; import
 * com.google.gdata.util.ServiceException;
 * 
 * public class ReadSpreadsheet { public static final String
 * GOOGLE_ACCOUNT_USERNAME = "amrace321@gmail.com"; // Fill in google account
 * username. public static final String GOOGLE_ACCOUNT_PASSWORD = "ramdam123";
 * //Fill in google account password. public static final String SPREADSHEET_URL
 * ="https://spreadsheets.google.com/feeds/spreadsheets/1tT3V0VOSpu-eTYRFIFe4tWHOWZc369MoSo9mkGdnUUs";
 * //Fill in google spreadsheet URI
 * 
 * public static void main(String[] args) throws IOException, ServiceException {
 *//** Our view of Google Spreadsheets as an authenticated Google user. *//*
																			 * SpreadsheetService service = new
																			 * SpreadsheetService("Print Google Spreadsheet Demo"
																			 * );
																			 * 
																			 * // Login and prompt the user to pick a
																			 * sheet to use. service.setUserCredentials(
																			 * GOOGLE_ACCOUNT_USERNAME,
																			 * GOOGLE_ACCOUNT_PASSWORD);
																			 * 
																			 * // Load sheet. URL metafeedUrl = new
																			 * URL(SPREADSHEET_URL); SpreadsheetEntry
																			 * spreadsheet =
																			 * service.getEntry(metafeedUrl,
																			 * SpreadsheetEntry.class); URL listFeedUrl
																			 * = ((WorksheetEntry)
																			 * spreadsheet.getWorksheets().get(0)).
																			 * getListFeedUrl();
																			 * 
																			 * // Print entries. ListFeed feed
																			 * =(ListFeed) service.getFeed(listFeedUrl,
																			 * ListFeed.class); for(ListEntry entry :
																			 * feed.getEntries()) {
																			 * System.out.println("new row"); for(String
																			 * tag :
																			 * entry.getCustomElements().getTags()) {
																			 * System.out.println("     "+tag + ": " +
																			 * entry.getCustomElements().getValue(tag));
																			 * } } } }
																			 */