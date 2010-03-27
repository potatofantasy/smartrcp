package java.sql
{
 import cn.smartinvoke.RemoteObject;
 import java.sql.Wrapper;

[Bindable]
[RemoteClass(alias="java.sql.DatabaseMetaData")]
 public class DatabaseMetaData extends Wrapper {
  public function DatabaseMetaData(){
	 super();
  }

   public function getSQLStateType():int{
	 var retObj:Object=this.call("getSQLStateType",arguments);
	 return Number(retObj);

   }
   public function getJDBCMajorVersion():int{
	 var retObj:Object=this.call("getJDBCMajorVersion",arguments);
	 return Number(retObj);

   }
   public function supportsPositionedDelete():Boolean{
	 var retObj:Object=this.call("supportsPositionedDelete",arguments);
	 return retObj as Boolean;

   }
   public function getColumns(catalog:String,schemaPattern:String,tableNamePattern:String,columnNamePattern:String):ResultSet{
	 var retObj:Object=this.call("getColumns",arguments);
	 return retObj as ResultSet;

   }
   public function supportsLikeEscapeClause():Boolean{
	 var retObj:Object=this.call("supportsLikeEscapeClause",arguments);
	 return retObj as Boolean;

   }
   public function getDriverMinorVersion():int{
	 var retObj:Object=this.call("getDriverMinorVersion",arguments);
	 return Number(retObj);

   }
   public function supportsTransactionIsolationLevel(level:int):Boolean{
	 var retObj:Object=this.call("supportsTransactionIsolationLevel",arguments);
	 return retObj as Boolean;

   }
   public function supportsANSI92EntryLevelSQL():Boolean{
	 var retObj:Object=this.call("supportsANSI92EntryLevelSQL",arguments);
	 return retObj as Boolean;

   }
   public function getResultSetHoldability():int{
	 var retObj:Object=this.call("getResultSetHoldability",arguments);
	 return Number(retObj);

   }
   public function supportsDataDefinitionAndDataManipulationTransactions():Boolean{
	 var retObj:Object=this.call("supportsDataDefinitionAndDataManipulationTransactions",arguments);
	 return retObj as Boolean;

   }
   public function supportsCorrelatedSubqueries():Boolean{
	 var retObj:Object=this.call("supportsCorrelatedSubqueries",arguments);
	 return retObj as Boolean;

   }
   public function getVersionColumns(catalog:String,schema:String,table:String):ResultSet{
	 var retObj:Object=this.call("getVersionColumns",arguments);
	 return retObj as ResultSet;

   }
   public function supportsOpenCursorsAcrossRollback():Boolean{
	 var retObj:Object=this.call("supportsOpenCursorsAcrossRollback",arguments);
	 return retObj as Boolean;

   }
   public function usesLocalFiles():Boolean{
	 var retObj:Object=this.call("usesLocalFiles",arguments);
	 return retObj as Boolean;

   }
   public function supportsResultSetConcurrency(type:int,concurrency:int):Boolean{
	 var retObj:Object=this.call("supportsResultSetConcurrency",arguments);
	 return retObj as Boolean;

   }
   public function getRowIdLifetime():RowIdLifetime{
	 var retObj:Object=this.call("getRowIdLifetime",arguments);
	 return retObj as RowIdLifetime;

   }
   public function ownInsertsAreVisible(type:int):Boolean{
	 var retObj:Object=this.call("ownInsertsAreVisible",arguments);
	 return retObj as Boolean;

   }
   public function getImportedKeys(catalog:String,schema:String,table:String):ResultSet{
	 var retObj:Object=this.call("getImportedKeys",arguments);
	 return retObj as ResultSet;

   }
   public function getClientInfoProperties():ResultSet{
	 var retObj:Object=this.call("getClientInfoProperties",arguments);
	 return retObj as ResultSet;

   }
   public function getProcedureColumns(catalog:String,schemaPattern:String,procedureNamePattern:String,columnNamePattern:String):ResultSet{
	 var retObj:Object=this.call("getProcedureColumns",arguments);
	 return retObj as ResultSet;

   }
   public function getFunctions(catalog:String,schemaPattern:String,functionNamePattern:String):ResultSet{
	 var retObj:Object=this.call("getFunctions",arguments);
	 return retObj as ResultSet;

   }
   public function getSQLKeywords():String{
	 var retObj:Object=this.call("getSQLKeywords",arguments);
	 return retObj as String;

   }
   public function getProcedureTerm():String{
	 var retObj:Object=this.call("getProcedureTerm",arguments);
	 return retObj as String;

   }
   public function supportsSchemasInDataManipulation():Boolean{
	 var retObj:Object=this.call("supportsSchemasInDataManipulation",arguments);
	 return retObj as Boolean;

   }
   public function getJDBCMinorVersion():int{
	 var retObj:Object=this.call("getJDBCMinorVersion",arguments);
	 return Number(retObj);

   }
   public function getTablePrivileges(catalog:String,schemaPattern:String,tableNamePattern:String):ResultSet{
	 var retObj:Object=this.call("getTablePrivileges",arguments);
	 return retObj as ResultSet;

   }
   public function supportsSchemasInTableDefinitions():Boolean{
	 var retObj:Object=this.call("supportsSchemasInTableDefinitions",arguments);
	 return retObj as Boolean;

   }
   public function getMaxUserNameLength():int{
	 var retObj:Object=this.call("getMaxUserNameLength",arguments);
	 return Number(retObj);

   }
   public function supportsSubqueriesInQuantifieds():Boolean{
	 var retObj:Object=this.call("supportsSubqueriesInQuantifieds",arguments);
	 return retObj as Boolean;

   }
   public function supportsSelectForUpdate():Boolean{
	 var retObj:Object=this.call("supportsSelectForUpdate",arguments);
	 return retObj as Boolean;

   }
   public function storesMixedCaseIdentifiers():Boolean{
	 var retObj:Object=this.call("storesMixedCaseIdentifiers",arguments);
	 return retObj as Boolean;

   }
   public function supportsSchemasInIndexDefinitions():Boolean{
	 var retObj:Object=this.call("supportsSchemasInIndexDefinitions",arguments);
	 return retObj as Boolean;

   }
   public function getMaxCursorNameLength():int{
	 var retObj:Object=this.call("getMaxCursorNameLength",arguments);
	 return Number(retObj);

   }
   public function getPrimaryKeys(catalog:String,schema:String,table:String):ResultSet{
	 var retObj:Object=this.call("getPrimaryKeys",arguments);
	 return retObj as ResultSet;

   }
   public function autoCommitFailureClosesAllResultSets():Boolean{
	 var retObj:Object=this.call("autoCommitFailureClosesAllResultSets",arguments);
	 return retObj as Boolean;

   }
   public function supportsSubqueriesInIns():Boolean{
	 var retObj:Object=this.call("supportsSubqueriesInIns",arguments);
	 return retObj as Boolean;

   }
   public function getDatabaseMajorVersion():int{
	 var retObj:Object=this.call("getDatabaseMajorVersion",arguments);
	 return Number(retObj);

   }
   public function supportsCatalogsInPrivilegeDefinitions():Boolean{
	 var retObj:Object=this.call("supportsCatalogsInPrivilegeDefinitions",arguments);
	 return retObj as Boolean;

   }
   public function ownDeletesAreVisible(type:int):Boolean{
	 var retObj:Object=this.call("ownDeletesAreVisible",arguments);
	 return retObj as Boolean;

   }
   public function supportsNonNullableColumns():Boolean{
	 var retObj:Object=this.call("supportsNonNullableColumns",arguments);
	 return retObj as Boolean;

   }
   public function othersUpdatesAreVisible(type:int):Boolean{
	 var retObj:Object=this.call("othersUpdatesAreVisible",arguments);
	 return retObj as Boolean;

   }
   public function getNumericFunctions():String{
	 var retObj:Object=this.call("getNumericFunctions",arguments);
	 return retObj as String;

   }
   public function supportsNamedParameters():Boolean{
	 var retObj:Object=this.call("supportsNamedParameters",arguments);
	 return retObj as Boolean;

   }
   public function getMaxColumnsInOrderBy():int{
	 var retObj:Object=this.call("getMaxColumnsInOrderBy",arguments);
	 return Number(retObj);

   }
   public function dataDefinitionIgnoredInTransactions():Boolean{
	 var retObj:Object=this.call("dataDefinitionIgnoredInTransactions",arguments);
	 return retObj as Boolean;

   }
   public function nullsAreSortedAtStart():Boolean{
	 var retObj:Object=this.call("nullsAreSortedAtStart",arguments);
	 return retObj as Boolean;

   }
   public function getMaxIndexLength():int{
	 var retObj:Object=this.call("getMaxIndexLength",arguments);
	 return Number(retObj);

   }
   public function storesUpperCaseQuotedIdentifiers():Boolean{
	 var retObj:Object=this.call("storesUpperCaseQuotedIdentifiers",arguments);
	 return retObj as Boolean;

   }
   public function supportsTableCorrelationNames():Boolean{
	 var retObj:Object=this.call("supportsTableCorrelationNames",arguments);
	 return retObj as Boolean;

   }
   public function supportsStatementPooling():Boolean{
	 var retObj:Object=this.call("supportsStatementPooling",arguments);
	 return retObj as Boolean;

   }
   public function getExtraNameCharacters():String{
	 var retObj:Object=this.call("getExtraNameCharacters",arguments);
	 return retObj as String;

   }
   public function supportsSchemasInProcedureCalls():Boolean{
	 var retObj:Object=this.call("supportsSchemasInProcedureCalls",arguments);
	 return retObj as Boolean;

   }
   public function storesLowerCaseIdentifiers():Boolean{
	 var retObj:Object=this.call("storesLowerCaseIdentifiers",arguments);
	 return retObj as Boolean;

   }
   public function isReadOnly():Boolean{
	 var retObj:Object=this.call("isReadOnly",arguments);
	 return retObj as Boolean;

   }
   public function supportsSubqueriesInComparisons():Boolean{
	 var retObj:Object=this.call("supportsSubqueriesInComparisons",arguments);
	 return retObj as Boolean;

   }
   public function getConnection():Connection{
	 var retObj:Object=this.call("getConnection",arguments);
	 return retObj as Connection;

   }
   public function getMaxColumnsInGroupBy():int{
	 var retObj:Object=this.call("getMaxColumnsInGroupBy",arguments);
	 return Number(retObj);

   }
   public function nullsAreSortedLow():Boolean{
	 var retObj:Object=this.call("nullsAreSortedLow",arguments);
	 return retObj as Boolean;

   }
   public function othersInsertsAreVisible(type:int):Boolean{
	 var retObj:Object=this.call("othersInsertsAreVisible",arguments);
	 return retObj as Boolean;

   }
   public function getBestRowIdentifier(catalog:String,schema:String,table:String,scope:int,nullable:Boolean):ResultSet{
	 var retObj:Object=this.call("getBestRowIdentifier",arguments);
	 return retObj as ResultSet;

   }
   public function supportsConvert():Boolean{
	 var retObj:Object=this.call("supportsConvert",arguments);
	 return retObj as Boolean;

   }
   public function supportsConvert1(fromType:int,toType:int):Boolean{
	 var retObj:Object=this.call("supportsConvert",arguments);
	 return retObj as Boolean;

   }
   public function supportsCatalogsInProcedureCalls():Boolean{
	 var retObj:Object=this.call("supportsCatalogsInProcedureCalls",arguments);
	 return retObj as Boolean;

   }
   public function getMaxCatalogNameLength():int{
	 var retObj:Object=this.call("getMaxCatalogNameLength",arguments);
	 return Number(retObj);

   }
   public function supportsMixedCaseQuotedIdentifiers():Boolean{
	 var retObj:Object=this.call("supportsMixedCaseQuotedIdentifiers",arguments);
	 return retObj as Boolean;

   }
   public function getMaxColumnsInSelect():int{
	 var retObj:Object=this.call("getMaxColumnsInSelect",arguments);
	 return Number(retObj);

   }
   public function getUDTs(catalog:String,schemaPattern:String,typeNamePattern:String,types:Array):ResultSet{
	 var retObj:Object=this.call("getUDTs",arguments);
	 return retObj as ResultSet;

   }
   public function getSuperTypes(catalog:String,schemaPattern:String,typeNamePattern:String):ResultSet{
	 var retObj:Object=this.call("getSuperTypes",arguments);
	 return retObj as ResultSet;

   }
   public function getMaxStatementLength():int{
	 var retObj:Object=this.call("getMaxStatementLength",arguments);
	 return Number(retObj);

   }
   public function getMaxCharLiteralLength():int{
	 var retObj:Object=this.call("getMaxCharLiteralLength",arguments);
	 return Number(retObj);

   }
   public function storesLowerCaseQuotedIdentifiers():Boolean{
	 var retObj:Object=this.call("storesLowerCaseQuotedIdentifiers",arguments);
	 return retObj as Boolean;

   }
   public function supportsCatalogsInTableDefinitions():Boolean{
	 var retObj:Object=this.call("supportsCatalogsInTableDefinitions",arguments);
	 return retObj as Boolean;

   }
   public function getMaxColumnNameLength():int{
	 var retObj:Object=this.call("getMaxColumnNameLength",arguments);
	 return Number(retObj);

   }
   public function supportsAlterTableWithAddColumn():Boolean{
	 var retObj:Object=this.call("supportsAlterTableWithAddColumn",arguments);
	 return retObj as Boolean;

   }
   public function doesMaxRowSizeIncludeBlobs():Boolean{
	 var retObj:Object=this.call("doesMaxRowSizeIncludeBlobs",arguments);
	 return retObj as Boolean;

   }
   public function getMaxSchemaNameLength():int{
	 var retObj:Object=this.call("getMaxSchemaNameLength",arguments);
	 return Number(retObj);

   }
   public function supportsOpenStatementsAcrossRollback():Boolean{
	 var retObj:Object=this.call("supportsOpenStatementsAcrossRollback",arguments);
	 return retObj as Boolean;

   }
   public function supportsDataManipulationTransactionsOnly():Boolean{
	 var retObj:Object=this.call("supportsDataManipulationTransactionsOnly",arguments);
	 return retObj as Boolean;

   }
   public function getMaxBinaryLiteralLength():int{
	 var retObj:Object=this.call("getMaxBinaryLiteralLength",arguments);
	 return Number(retObj);

   }
   public function supportsCoreSQLGrammar():Boolean{
	 var retObj:Object=this.call("supportsCoreSQLGrammar",arguments);
	 return retObj as Boolean;

   }
   public function getMaxTablesInSelect():int{
	 var retObj:Object=this.call("getMaxTablesInSelect",arguments);
	 return Number(retObj);

   }
   public function supportsMultipleResultSets():Boolean{
	 var retObj:Object=this.call("supportsMultipleResultSets",arguments);
	 return retObj as Boolean;

   }
   public function supportsGroupByUnrelated():Boolean{
	 var retObj:Object=this.call("supportsGroupByUnrelated",arguments);
	 return retObj as Boolean;

   }
   public function othersDeletesAreVisible(type:int):Boolean{
	 var retObj:Object=this.call("othersDeletesAreVisible",arguments);
	 return retObj as Boolean;

   }
   public function supportsCatalogsInDataManipulation():Boolean{
	 var retObj:Object=this.call("supportsCatalogsInDataManipulation",arguments);
	 return retObj as Boolean;

   }
   public function supportsUnion():Boolean{
	 var retObj:Object=this.call("supportsUnion",arguments);
	 return retObj as Boolean;

   }
   public function getDatabaseMinorVersion():int{
	 var retObj:Object=this.call("getDatabaseMinorVersion",arguments);
	 return Number(retObj);

   }
   public function supportsSavepoints():Boolean{
	 var retObj:Object=this.call("supportsSavepoints",arguments);
	 return retObj as Boolean;

   }
   public function deletesAreDetected(type:int):Boolean{
	 var retObj:Object=this.call("deletesAreDetected",arguments);
	 return retObj as Boolean;

   }
   public function updatesAreDetected(type:int):Boolean{
	 var retObj:Object=this.call("updatesAreDetected",arguments);
	 return retObj as Boolean;

   }
   public function supportsExpressionsInOrderBy():Boolean{
	 var retObj:Object=this.call("supportsExpressionsInOrderBy",arguments);
	 return retObj as Boolean;

   }
   public function storesMixedCaseQuotedIdentifiers():Boolean{
	 var retObj:Object=this.call("storesMixedCaseQuotedIdentifiers",arguments);
	 return retObj as Boolean;

   }
   public function supportsTransactions():Boolean{
	 var retObj:Object=this.call("supportsTransactions",arguments);
	 return retObj as Boolean;

   }
   public function getColumnPrivileges(catalog:String,schema:String,table:String,columnNamePattern:String):ResultSet{
	 var retObj:Object=this.call("getColumnPrivileges",arguments);
	 return retObj as ResultSet;

   }
   public function getDriverMajorVersion():int{
	 var retObj:Object=this.call("getDriverMajorVersion",arguments);
	 return Number(retObj);

   }
   public function usesLocalFilePerTable():Boolean{
	 var retObj:Object=this.call("usesLocalFilePerTable",arguments);
	 return retObj as Boolean;

   }
   public function getMaxColumnsInIndex():int{
	 var retObj:Object=this.call("getMaxColumnsInIndex",arguments);
	 return Number(retObj);

   }
   public function supportsGroupBy():Boolean{
	 var retObj:Object=this.call("supportsGroupBy",arguments);
	 return retObj as Boolean;

   }
   public function supportsOpenCursorsAcrossCommit():Boolean{
	 var retObj:Object=this.call("supportsOpenCursorsAcrossCommit",arguments);
	 return retObj as Boolean;

   }
   public function getDriverVersion():String{
	 var retObj:Object=this.call("getDriverVersion",arguments);
	 return retObj as String;

   }
   public function supportsOrderByUnrelated():Boolean{
	 var retObj:Object=this.call("supportsOrderByUnrelated",arguments);
	 return retObj as Boolean;

   }
   public function insertsAreDetected(type:int):Boolean{
	 var retObj:Object=this.call("insertsAreDetected",arguments);
	 return retObj as Boolean;

   }
   public function dataDefinitionCausesTransactionCommit():Boolean{
	 var retObj:Object=this.call("dataDefinitionCausesTransactionCommit",arguments);
	 return retObj as Boolean;

   }
   public function nullsAreSortedHigh():Boolean{
	 var retObj:Object=this.call("nullsAreSortedHigh",arguments);
	 return retObj as Boolean;

   }
   public function getMaxRowSize():int{
	 var retObj:Object=this.call("getMaxRowSize",arguments);
	 return Number(retObj);

   }
   public function locatorsUpdateCopy():Boolean{
	 var retObj:Object=this.call("locatorsUpdateCopy",arguments);
	 return retObj as Boolean;

   }
   public function getSchemaTerm():String{
	 var retObj:Object=this.call("getSchemaTerm",arguments);
	 return retObj as String;

   }
   public function supportsLimitedOuterJoins():Boolean{
	 var retObj:Object=this.call("supportsLimitedOuterJoins",arguments);
	 return retObj as Boolean;

   }
   public function ownUpdatesAreVisible(type:int):Boolean{
	 var retObj:Object=this.call("ownUpdatesAreVisible",arguments);
	 return retObj as Boolean;

   }
   public function getMaxTableNameLength():int{
	 var retObj:Object=this.call("getMaxTableNameLength",arguments);
	 return Number(retObj);

   }
   public function supportsMultipleTransactions():Boolean{
	 var retObj:Object=this.call("supportsMultipleTransactions",arguments);
	 return retObj as Boolean;

   }
   public function supportsColumnAliasing():Boolean{
	 var retObj:Object=this.call("supportsColumnAliasing",arguments);
	 return retObj as Boolean;

   }
   public function supportsCatalogsInIndexDefinitions():Boolean{
	 var retObj:Object=this.call("supportsCatalogsInIndexDefinitions",arguments);
	 return retObj as Boolean;

   }
   public function supportsUnionAll():Boolean{
	 var retObj:Object=this.call("supportsUnionAll",arguments);
	 return retObj as Boolean;

   }
   public function supportsStoredFunctionsUsingCallSyntax():Boolean{
	 var retObj:Object=this.call("supportsStoredFunctionsUsingCallSyntax",arguments);
	 return retObj as Boolean;

   }
   public function getFunctionColumns(catalog:String,schemaPattern:String,functionNamePattern:String,columnNamePattern:String):ResultSet{
	 var retObj:Object=this.call("getFunctionColumns",arguments);
	 return retObj as ResultSet;

   }
   public function getExportedKeys(catalog:String,schema:String,table:String):ResultSet{
	 var retObj:Object=this.call("getExportedKeys",arguments);
	 return retObj as ResultSet;

   }
   public function allTablesAreSelectable():Boolean{
	 var retObj:Object=this.call("allTablesAreSelectable",arguments);
	 return retObj as Boolean;

   }
   public function getIdentifierQuoteString():String{
	 var retObj:Object=this.call("getIdentifierQuoteString",arguments);
	 return retObj as String;

   }
   public function supportsResultSetType(type:int):Boolean{
	 var retObj:Object=this.call("supportsResultSetType",arguments);
	 return retObj as Boolean;

   }
   public function getDefaultTransactionIsolation():int{
	 var retObj:Object=this.call("getDefaultTransactionIsolation",arguments);
	 return Number(retObj);

   }
   public function getCatalogs():ResultSet{
	 var retObj:Object=this.call("getCatalogs",arguments);
	 return retObj as ResultSet;

   }
   public function getProcedures(catalog:String,schemaPattern:String,procedureNamePattern:String):ResultSet{
	 var retObj:Object=this.call("getProcedures",arguments);
	 return retObj as ResultSet;

   }
   public function getMaxStatements():int{
	 var retObj:Object=this.call("getMaxStatements",arguments);
	 return Number(retObj);

   }
   public function supportsDifferentTableCorrelationNames():Boolean{
	 var retObj:Object=this.call("supportsDifferentTableCorrelationNames",arguments);
	 return retObj as Boolean;

   }
   public function getDriverName():String{
	 var retObj:Object=this.call("getDriverName",arguments);
	 return retObj as String;

   }
   public function getURL():String{
	 var retObj:Object=this.call("getURL",arguments);
	 return retObj as String;

   }
   public function supportsMultipleOpenResults():Boolean{
	 var retObj:Object=this.call("supportsMultipleOpenResults",arguments);
	 return retObj as Boolean;

   }
   public function supportsBatchUpdates():Boolean{
	 var retObj:Object=this.call("supportsBatchUpdates",arguments);
	 return retObj as Boolean;

   }
   public function getAttributes(catalog:String,schemaPattern:String,typeNamePattern:String,attributeNamePattern:String):ResultSet{
	 var retObj:Object=this.call("getAttributes",arguments);
	 return retObj as ResultSet;

   }
   public function getUserName():String{
	 var retObj:Object=this.call("getUserName",arguments);
	 return retObj as String;

   }
   public function getDatabaseProductName():String{
	 var retObj:Object=this.call("getDatabaseProductName",arguments);
	 return retObj as String;

   }
   public function getMaxProcedureNameLength():int{
	 var retObj:Object=this.call("getMaxProcedureNameLength",arguments);
	 return Number(retObj);

   }
   public function getTableTypes():ResultSet{
	 var retObj:Object=this.call("getTableTypes",arguments);
	 return retObj as ResultSet;

   }
   public function getDatabaseProductVersion():String{
	 var retObj:Object=this.call("getDatabaseProductVersion",arguments);
	 return retObj as String;

   }
   public function isCatalogAtStart():Boolean{
	 var retObj:Object=this.call("isCatalogAtStart",arguments);
	 return retObj as Boolean;

   }
   public function supportsResultSetHoldability(holdability:int):Boolean{
	 var retObj:Object=this.call("supportsResultSetHoldability",arguments);
	 return retObj as Boolean;

   }
   public function getTypeInfo():ResultSet{
	 var retObj:Object=this.call("getTypeInfo",arguments);
	 return retObj as ResultSet;

   }
   public function supportsANSI92FullSQL():Boolean{
	 var retObj:Object=this.call("supportsANSI92FullSQL",arguments);
	 return retObj as Boolean;

   }
   public function getCatalogSeparator():String{
	 var retObj:Object=this.call("getCatalogSeparator",arguments);
	 return retObj as String;

   }
   public function getTables(catalog:String,schemaPattern:String,tableNamePattern:String,types[]:String):ResultSet{
	 var retObj:Object=this.call("getTables",arguments);
	 return retObj as ResultSet;

   }
   public function allProceduresAreCallable():Boolean{
	 var retObj:Object=this.call("allProceduresAreCallable",arguments);
	 return retObj as Boolean;

   }
   public function supportsMinimumSQLGrammar():Boolean{
	 var retObj:Object=this.call("supportsMinimumSQLGrammar",arguments);
	 return retObj as Boolean;

   }
   public function supportsSubqueriesInExists():Boolean{
	 var retObj:Object=this.call("supportsSubqueriesInExists",arguments);
	 return retObj as Boolean;

   }
   public function supportsGetGeneratedKeys():Boolean{
	 var retObj:Object=this.call("supportsGetGeneratedKeys",arguments);
	 return retObj as Boolean;

   }
   public function supportsOuterJoins():Boolean{
	 var retObj:Object=this.call("supportsOuterJoins",arguments);
	 return retObj as Boolean;

   }
   public function storesUpperCaseIdentifiers():Boolean{
	 var retObj:Object=this.call("storesUpperCaseIdentifiers",arguments);
	 return retObj as Boolean;

   }
   public function nullsAreSortedAtEnd():Boolean{
	 var retObj:Object=this.call("nullsAreSortedAtEnd",arguments);
	 return retObj as Boolean;

   }
   public function supportsIntegrityEnhancementFacility():Boolean{
	 var retObj:Object=this.call("supportsIntegrityEnhancementFacility",arguments);
	 return retObj as Boolean;

   }
   public function supportsPositionedUpdate():Boolean{
	 var retObj:Object=this.call("supportsPositionedUpdate",arguments);
	 return retObj as Boolean;

   }
   public function getIndexInfo(catalog:String,schema:String,table:String,unique:Boolean,approximate:Boolean):ResultSet{
	 var retObj:Object=this.call("getIndexInfo",arguments);
	 return retObj as ResultSet;

   }
   public function getSearchStringEscape():String{
	 var retObj:Object=this.call("getSearchStringEscape",arguments);
	 return retObj as String;

   }
   public function supportsMixedCaseIdentifiers():Boolean{
	 var retObj:Object=this.call("supportsMixedCaseIdentifiers",arguments);
	 return retObj as Boolean;

   }
   public function supportsANSI92IntermediateSQL():Boolean{
	 var retObj:Object=this.call("supportsANSI92IntermediateSQL",arguments);
	 return retObj as Boolean;

   }
   public function getSuperTables(catalog:String,schemaPattern:String,tableNamePattern:String):ResultSet{
	 var retObj:Object=this.call("getSuperTables",arguments);
	 return retObj as ResultSet;

   }
   public function getSystemFunctions():String{
	 var retObj:Object=this.call("getSystemFunctions",arguments);
	 return retObj as String;

   }
   public function supportsAlterTableWithDropColumn():Boolean{
	 var retObj:Object=this.call("supportsAlterTableWithDropColumn",arguments);
	 return retObj as Boolean;

   }
   public function supportsExtendedSQLGrammar():Boolean{
	 var retObj:Object=this.call("supportsExtendedSQLGrammar",arguments);
	 return retObj as Boolean;

   }
   public function getCatalogTerm():String{
	 var retObj:Object=this.call("getCatalogTerm",arguments);
	 return retObj as String;

   }
   public function supportsGroupByBeyondSelect():Boolean{
	 var retObj:Object=this.call("supportsGroupByBeyondSelect",arguments);
	 return retObj as Boolean;

   }
   public function getMaxColumnsInTable():int{
	 var retObj:Object=this.call("getMaxColumnsInTable",arguments);
	 return Number(retObj);

   }
   public function supportsStoredProcedures():Boolean{
	 var retObj:Object=this.call("supportsStoredProcedures",arguments);
	 return retObj as Boolean;

   }
   public function getMaxConnections():int{
	 var retObj:Object=this.call("getMaxConnections",arguments);
	 return Number(retObj);

   }
   public function getTimeDateFunctions():String{
	 var retObj:Object=this.call("getTimeDateFunctions",arguments);
	 return retObj as String;

   }
   public function getStringFunctions():String{
	 var retObj:Object=this.call("getStringFunctions",arguments);
	 return retObj as String;

   }
   public function getCrossReference(parentCatalog:String,parentSchema:String,parentTable:String,foreignCatalog:String,foreignSchema:String,foreignTable:String):ResultSet{
	 var retObj:Object=this.call("getCrossReference",arguments);
	 return retObj as ResultSet;

   }
   public function nullPlusNonNullIsNull():Boolean{
	 var retObj:Object=this.call("nullPlusNonNullIsNull",arguments);
	 return retObj as Boolean;

   }
   public function supportsSchemasInPrivilegeDefinitions():Boolean{
	 var retObj:Object=this.call("supportsSchemasInPrivilegeDefinitions",arguments);
	 return retObj as Boolean;

   }
   public function supportsFullOuterJoins():Boolean{
	 var retObj:Object=this.call("supportsFullOuterJoins",arguments);
	 return retObj as Boolean;

   }
   public function supportsOpenStatementsAcrossCommit():Boolean{
	 var retObj:Object=this.call("supportsOpenStatementsAcrossCommit",arguments);
	 return retObj as Boolean;

   }
   public function getSchemas():ResultSet{
	 var retObj:Object=this.call("getSchemas",arguments);
	 return retObj as ResultSet;

   }
   public function getSchemas1(catalog:String,schemaPattern:String):ResultSet{
	 var retObj:Object=this.call("getSchemas",arguments);
	 return retObj as ResultSet;

   }
 }

}
