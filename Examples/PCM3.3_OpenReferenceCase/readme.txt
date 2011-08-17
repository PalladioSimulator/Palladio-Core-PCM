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
Open Reference Case
--------------------------------------------------------------------

Changes:
- added new Repository "ws.repository" for Web Services on Top of CoCoME
- updated "cocomeTypes.repository" to support Web Service Interface definitions
  - added new composite data types / collection data types as needed
  - simplified collection data types: "java.util.List<T>" and "java.util.Collection<T>" are modeled as "T[]"
- updated "cocome.resourceenvironment":
  - added new ResourceContainer "ServiceProvider"
  - added new LinkingResources between ServiceProvider Store_1_Client / Store_2_Client
- updated "cocome.system":
  - added AssemblyContexts for WebServices
  - renamed System "TradingSystem.Inventory" in "ServiceOrientedRetailSolution"
- updated "cocome.allocation":
  - added deployment of WebServices at ServiceProvider


--------------------------------------------------------------------
Open Reference Case: Differences between Model and Implementation
--------------------------------------------------------------------

- WebServices instantiated once for multiple Stores:
  - The model implicitly assumes that each of the WebServices is instantiated only once for
    all stores of an enterprise.
  - To support that, the implementation would have to pass the storeId as an additional input
    parameter to all service calls.
- Use Case 8 (fill up stocks in one store by ordering goods from other stores):
  - In the implementation, this is done during each sales process as a part of the
    Application.Store.bookSale() method.
  - In the model, there is an extra signature "checkForLowRunningGoods" as part of the
    StoreIf interface. The functionality is so far not reachable at the system border.
- ProductDispatcher.orderProductsAvailableAtOtherStores - Fehler in Implementierung:
  - der callingStore müsste aus der stores-Collection entfernt werden (?)
  - der PersistenceContext müsste am Ende wieder geschlossen werden (?)
- In der Modellierung sind Sonderfälle wie try-catch-Konstrukte nicht explizit im Kontrollfluss
  berücksichtigt. Da diese Sonderfälle grundsätzlich bedeuten, dass die eigentlich angedachte
  Funktionalität nicht ausgeführt werden kann, sind sie mit einem "Failure" des entsprechenden
  Dienstes gleichzusetzen. Ziel der Modellierung ist, die Wahrscheinlichkeiten von "Failures"
  zu berechnen. Dazu können die "FailureProbabilities" der InternalActions genutzt werden.
  
--------------------------------------------------------------------
Update 2011-07-06: Model udpated to PCM Version 3.3
--------------------------------------------------------------------
  