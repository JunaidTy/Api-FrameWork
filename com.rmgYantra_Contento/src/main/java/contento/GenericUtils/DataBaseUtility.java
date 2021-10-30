package contento.GenericUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import com.mysql.cj.jdbc.Driver;
/**
 * this class contains generic methods to get the data from DB
 * @author JAnsari
 *
 */
public class DataBaseUtility {
	
	Connection con;
	ResultSet result;
	public void connectToDB() throws Throwable
	{
		Driver driverRef=new Driver();
		DriverManager.registerDriver(driverRef);
		con = DriverManager.getConnection(IPathConstant.dbURL,IPathConstant.dbUserName,IPathConstant.dbPassword);
	}
	/**
	 * this method returns the data wrt to coloum index
	 * @throws Throwable
	 */
	public void closeDB() throws Throwable
	{
		con.close();
	}
	public String getDataFromDB(String query,int coloumnindex,String expData) throws Throwable {
		Boolean flag=false;
		result = con.createStatement().executeQuery(query);
		while(result.next())
		{
			String actData=result.getString(coloumnindex);
			if(actData.equalsIgnoreCase(expData))
			{
				flag=true;
				break;
			}
			
		}
		if(flag==true)
			
		{
			System.out.println(expData+" Data verified sucessfully");
			return expData;
		}
		
		else
		{
			System.out.println(expData+" Data not verified in DB");
			return "";
		}
	}
}
