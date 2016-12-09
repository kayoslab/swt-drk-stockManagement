package model.databaseObjects.stockObjects;

import model.databaseObjects.DatabaseObject;

public class Material extends StockObject {
	public int batchSize;
	public int minimumStock;
	public int quotaStock;
	
	public Material(int id, String title, String description, Boolean silencedWarnings, DatabaseObject.StockObjectType type, int totalVolume, 
					int batchSize, int minimumStock, int quotaStock) {
		super(id, title, description, silencedWarnings, type, totalVolume);
		this.batchSize = batchSize;
		this.minimumStock = minimumStock;
		this.quotaStock = quotaStock;
	}

}