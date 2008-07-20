--------------------------------------------------------------------
PCM Model Instance of CoCoME
--------------------------------------------------------------------
see:
- http://cocome.org/
- http://sdqweb.ipd.uka.de/wiki/CoCoME-PCM
--------------------------------------------------------------------

--------------------------------------------------------------------
Original Notes of CoCoME PCM
--------------------------------------------------------------------

Modelling:
- Introduced a facade component for
	- TradingSystem.Inventory.Data
	- TradingSystem.Inventory.Application
to support business logic for composite structures

Assembly Connectors at requires side of ProductDispatcher are missing

Short comings
- Had to add Facade components
- Left out POS-Part of CoCoME
- Distribution: 1:n relations between StoreServer and EnterpriseServer has to be modelled
explicitly
- Simplified allocation: 3 on 3: inventory, data, gui
- Inventory CC allocated - not system 

Signatures:
- used int instead of long for all ids in signatures
- All non-primitive and non-collection data types are modeled as CompositeDataTypes
- made TYPE[] data types collection data types with inner composite data type of type TYPE
- Exceptions are not modelled because of a lack of support by analysis tools

SEFFs finished:
- org.cocome.tradingsystem.inventory.application.store:
	- bookSale(SaleTO saleTO)
- org.cocome.tradingsystem.inventory.data.store.impl.StoreQueryImpl
	- queryStockItemById(long stockId, PersistenceContext pctx)
	- queryLowStockItemsWithRespectToIncomingProducts(long storeId, PersistenceContext pctx)
	- QueryStockItem
- org.cocome.tradingsystem.inventory.data.persistence.impl.PersistenceImpl
	- getPersistenceContext()
- org.cocome.tradingsystem.inventory.application.productdispatcher.impl.ProductDispatcher
	- orderProductsAvailableAtOtherStores(
			EnterpriseTO enterpriseTO, StoreTO callingStore,
			Collection<ProductAmountTO> productAmounts)
	
SEFF modeling problems:
- only first call is a interface call. TransactionContext is returned --> NOT a pure data type.
		PersistenceContext pctx = persistmanager.getPersistenceContext();
		TransactionContext tx = null;

		try {
			tx = pctx.getTransactionContext();
			tx.beginTransaction();
- Concurrency for parallel databaseFlush() is not supported. A loop is modelled instead with
one iteration for each concurrent thread.


--------------------------------------------------------------------
Notes of CoCoME PCM Extension for SLA@SOI
--------------------------------------------------------------------

Changes:
- deleted old project files
- deleted JDBC required interfaces from data and system component
- deleted Resource Container "StoreServerProcessorShare"
