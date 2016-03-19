// Generated from sql.g4 by ANTLR 4.4
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link sqlParser}.
 */
public interface sqlListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link sqlParser#use_schema_statement}.
	 * @param ctx the parse tree
	 */
	void enterUse_schema_statement(@NotNull sqlParser.Use_schema_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link sqlParser#use_schema_statement}.
	 * @param ctx the parse tree
	 */
	void exitUse_schema_statement(@NotNull sqlParser.Use_schema_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link sqlParser#tipo}.
	 * @param ctx the parse tree
	 */
	void enterTipo(@NotNull sqlParser.TipoContext ctx);
	/**
	 * Exit a parse tree produced by {@link sqlParser#tipo}.
	 * @param ctx the parse tree
	 */
	void exitTipo(@NotNull sqlParser.TipoContext ctx);
	/**
	 * Enter a parse tree produced by {@link sqlParser#table_definition}.
	 * @param ctx the parse tree
	 */
	void enterTable_definition(@NotNull sqlParser.Table_definitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link sqlParser#table_definition}.
	 * @param ctx the parse tree
	 */
	void exitTable_definition(@NotNull sqlParser.Table_definitionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code literal_date}
	 * labeled alternative in {@link sqlParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral_date(@NotNull sqlParser.Literal_dateContext ctx);
	/**
	 * Exit a parse tree produced by the {@code literal_date}
	 * labeled alternative in {@link sqlParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral_date(@NotNull sqlParser.Literal_dateContext ctx);
	/**
	 * Enter a parse tree produced by the {@code accionDropColumn}
	 * labeled alternative in {@link sqlParser#accion}.
	 * @param ctx the parse tree
	 */
	void enterAccionDropColumn(@NotNull sqlParser.AccionDropColumnContext ctx);
	/**
	 * Exit a parse tree produced by the {@code accionDropColumn}
	 * labeled alternative in {@link sqlParser#accion}.
	 * @param ctx the parse tree
	 */
	void exitAccionDropColumn(@NotNull sqlParser.AccionDropColumnContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expLogic}
	 * labeled alternative in {@link sqlParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterExpLogic(@NotNull sqlParser.ExpLogicContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expLogic}
	 * labeled alternative in {@link sqlParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitExpLogic(@NotNull sqlParser.ExpLogicContext ctx);
	/**
	 * Enter a parse tree produced by the {@code schemaDefinition}
	 * labeled alternative in {@link sqlParser#sql_schema_definition_statement}.
	 * @param ctx the parse tree
	 */
	void enterSchemaDefinition(@NotNull sqlParser.SchemaDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code schemaDefinition}
	 * labeled alternative in {@link sqlParser#sql_schema_definition_statement}.
	 * @param ctx the parse tree
	 */
	void exitSchemaDefinition(@NotNull sqlParser.SchemaDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expRelational}
	 * labeled alternative in {@link sqlParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterExpRelational(@NotNull sqlParser.ExpRelationalContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expRelational}
	 * labeled alternative in {@link sqlParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitExpRelational(@NotNull sqlParser.ExpRelationalContext ctx);
	/**
	 * Enter a parse tree produced by {@link sqlParser#int_literal}.
	 * @param ctx the parse tree
	 */
	void enterInt_literal(@NotNull sqlParser.Int_literalContext ctx);
	/**
	 * Exit a parse tree produced by {@link sqlParser#int_literal}.
	 * @param ctx the parse tree
	 */
	void exitInt_literal(@NotNull sqlParser.Int_literalContext ctx);
	/**
	 * Enter a parse tree produced by {@link sqlParser#alter_table_statement}.
	 * @param ctx the parse tree
	 */
	void enterAlter_table_statement(@NotNull sqlParser.Alter_table_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link sqlParser#alter_table_statement}.
	 * @param ctx the parse tree
	 */
	void exitAlter_table_statement(@NotNull sqlParser.Alter_table_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link sqlParser#alter_database_statement}.
	 * @param ctx the parse tree
	 */
	void enterAlter_database_statement(@NotNull sqlParser.Alter_database_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link sqlParser#alter_database_statement}.
	 * @param ctx the parse tree
	 */
	void exitAlter_database_statement(@NotNull sqlParser.Alter_database_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link sqlParser#sql2003Parser}.
	 * @param ctx the parse tree
	 */
	void enterSql2003Parser(@NotNull sqlParser.Sql2003ParserContext ctx);
	/**
	 * Exit a parse tree produced by {@link sqlParser#sql2003Parser}.
	 * @param ctx the parse tree
	 */
	void exitSql2003Parser(@NotNull sqlParser.Sql2003ParserContext ctx);
	/**
	 * Enter a parse tree produced by {@link sqlParser#delete_value}.
	 * @param ctx the parse tree
	 */
	void enterDelete_value(@NotNull sqlParser.Delete_valueContext ctx);
	/**
	 * Exit a parse tree produced by {@link sqlParser#delete_value}.
	 * @param ctx the parse tree
	 */
	void exitDelete_value(@NotNull sqlParser.Delete_valueContext ctx);
	/**
	 * Enter a parse tree produced by {@link sqlParser#char_literal}.
	 * @param ctx the parse tree
	 */
	void enterChar_literal(@NotNull sqlParser.Char_literalContext ctx);
	/**
	 * Exit a parse tree produced by {@link sqlParser#char_literal}.
	 * @param ctx the parse tree
	 */
	void exitChar_literal(@NotNull sqlParser.Char_literalContext ctx);
	/**
	 * Enter a parse tree produced by the {@code accionAddColumn}
	 * labeled alternative in {@link sqlParser#accion}.
	 * @param ctx the parse tree
	 */
	void enterAccionAddColumn(@NotNull sqlParser.AccionAddColumnContext ctx);
	/**
	 * Exit a parse tree produced by the {@code accionAddColumn}
	 * labeled alternative in {@link sqlParser#accion}.
	 * @param ctx the parse tree
	 */
	void exitAccionAddColumn(@NotNull sqlParser.AccionAddColumnContext ctx);
	/**
	 * Enter a parse tree produced by the {@code schemaDefinitionStatement}
	 * labeled alternative in {@link sqlParser#sql_schema_statement}.
	 * @param ctx the parse tree
	 */
	void enterSchemaDefinitionStatement(@NotNull sqlParser.SchemaDefinitionStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code schemaDefinitionStatement}
	 * labeled alternative in {@link sqlParser#sql_schema_statement}.
	 * @param ctx the parse tree
	 */
	void exitSchemaDefinitionStatement(@NotNull sqlParser.SchemaDefinitionStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link sqlParser#tipo_literal}.
	 * @param ctx the parse tree
	 */
	void enterTipo_literal(@NotNull sqlParser.Tipo_literalContext ctx);
	/**
	 * Exit a parse tree produced by {@link sqlParser#tipo_literal}.
	 * @param ctx the parse tree
	 */
	void exitTipo_literal(@NotNull sqlParser.Tipo_literalContext ctx);
	/**
	 * Enter a parse tree produced by {@link sqlParser#condition}.
	 * @param ctx the parse tree
	 */
	void enterCondition(@NotNull sqlParser.ConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link sqlParser#condition}.
	 * @param ctx the parse tree
	 */
	void exitCondition(@NotNull sqlParser.ConditionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code manipulationDropTable}
	 * labeled alternative in {@link sqlParser#sql_schema_manipulation_statement}.
	 * @param ctx the parse tree
	 */
	void enterManipulationDropTable(@NotNull sqlParser.ManipulationDropTableContext ctx);
	/**
	 * Exit a parse tree produced by the {@code manipulationDropTable}
	 * labeled alternative in {@link sqlParser#sql_schema_manipulation_statement}.
	 * @param ctx the parse tree
	 */
	void exitManipulationDropTable(@NotNull sqlParser.ManipulationDropTableContext ctx);
	/**
	 * Enter a parse tree produced by {@link sqlParser#rename_table_statement}.
	 * @param ctx the parse tree
	 */
	void enterRename_table_statement(@NotNull sqlParser.Rename_table_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link sqlParser#rename_table_statement}.
	 * @param ctx the parse tree
	 */
	void exitRename_table_statement(@NotNull sqlParser.Rename_table_statementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code schemaManipulationStatement}
	 * labeled alternative in {@link sqlParser#sql_schema_statement}.
	 * @param ctx the parse tree
	 */
	void enterSchemaManipulationStatement(@NotNull sqlParser.SchemaManipulationStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code schemaManipulationStatement}
	 * labeled alternative in {@link sqlParser#sql_schema_statement}.
	 * @param ctx the parse tree
	 */
	void exitSchemaManipulationStatement(@NotNull sqlParser.SchemaManipulationStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code literal_int}
	 * labeled alternative in {@link sqlParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral_int(@NotNull sqlParser.Literal_intContext ctx);
	/**
	 * Exit a parse tree produced by the {@code literal_int}
	 * labeled alternative in {@link sqlParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral_int(@NotNull sqlParser.Literal_intContext ctx);
	/**
	 * Enter a parse tree produced by {@link sqlParser#show_column_statement}.
	 * @param ctx the parse tree
	 */
	void enterShow_column_statement(@NotNull sqlParser.Show_column_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link sqlParser#show_column_statement}.
	 * @param ctx the parse tree
	 */
	void exitShow_column_statement(@NotNull sqlParser.Show_column_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link sqlParser#sql_data_statement}.
	 * @param ctx the parse tree
	 */
	void enterSql_data_statement(@NotNull sqlParser.Sql_data_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link sqlParser#sql_data_statement}.
	 * @param ctx the parse tree
	 */
	void exitSql_data_statement(@NotNull sqlParser.Sql_data_statementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code schemaStatement}
	 * labeled alternative in {@link sqlParser#sql_executable_statement}.
	 * @param ctx the parse tree
	 */
	void enterSchemaStatement(@NotNull sqlParser.SchemaStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code schemaStatement}
	 * labeled alternative in {@link sqlParser#sql_executable_statement}.
	 * @param ctx the parse tree
	 */
	void exitSchemaStatement(@NotNull sqlParser.SchemaStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link sqlParser#show_schema_statement}.
	 * @param ctx the parse tree
	 */
	void enterShow_schema_statement(@NotNull sqlParser.Show_schema_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link sqlParser#show_schema_statement}.
	 * @param ctx the parse tree
	 */
	void exitShow_schema_statement(@NotNull sqlParser.Show_schema_statementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code constraintForeignKey}
	 * labeled alternative in {@link sqlParser#constraintType}.
	 * @param ctx the parse tree
	 */
	void enterConstraintForeignKey(@NotNull sqlParser.ConstraintForeignKeyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code constraintForeignKey}
	 * labeled alternative in {@link sqlParser#constraintType}.
	 * @param ctx the parse tree
	 */
	void exitConstraintForeignKey(@NotNull sqlParser.ConstraintForeignKeyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code manipulationShowTable}
	 * labeled alternative in {@link sqlParser#sql_schema_manipulation_statement}.
	 * @param ctx the parse tree
	 */
	void enterManipulationShowTable(@NotNull sqlParser.ManipulationShowTableContext ctx);
	/**
	 * Exit a parse tree produced by the {@code manipulationShowTable}
	 * labeled alternative in {@link sqlParser#sql_schema_manipulation_statement}.
	 * @param ctx the parse tree
	 */
	void exitManipulationShowTable(@NotNull sqlParser.ManipulationShowTableContext ctx);
	/**
	 * Enter a parse tree produced by the {@code accionDropConstraint}
	 * labeled alternative in {@link sqlParser#accion}.
	 * @param ctx the parse tree
	 */
	void enterAccionDropConstraint(@NotNull sqlParser.AccionDropConstraintContext ctx);
	/**
	 * Exit a parse tree produced by the {@code accionDropConstraint}
	 * labeled alternative in {@link sqlParser#accion}.
	 * @param ctx the parse tree
	 */
	void exitAccionDropConstraint(@NotNull sqlParser.AccionDropConstraintContext ctx);
	/**
	 * Enter a parse tree produced by the {@code accionAddConstraint}
	 * labeled alternative in {@link sqlParser#accion}.
	 * @param ctx the parse tree
	 */
	void enterAccionAddConstraint(@NotNull sqlParser.AccionAddConstraintContext ctx);
	/**
	 * Exit a parse tree produced by the {@code accionAddConstraint}
	 * labeled alternative in {@link sqlParser#accion}.
	 * @param ctx the parse tree
	 */
	void exitAccionAddConstraint(@NotNull sqlParser.AccionAddConstraintContext ctx);
	/**
	 * Enter a parse tree produced by the {@code manipulationShowColumn}
	 * labeled alternative in {@link sqlParser#sql_schema_manipulation_statement}.
	 * @param ctx the parse tree
	 */
	void enterManipulationShowColumn(@NotNull sqlParser.ManipulationShowColumnContext ctx);
	/**
	 * Exit a parse tree produced by the {@code manipulationShowColumn}
	 * labeled alternative in {@link sqlParser#sql_schema_manipulation_statement}.
	 * @param ctx the parse tree
	 */
	void exitManipulationShowColumn(@NotNull sqlParser.ManipulationShowColumnContext ctx);
	/**
	 * Enter a parse tree produced by the {@code constraintCheck}
	 * labeled alternative in {@link sqlParser#constraintType}.
	 * @param ctx the parse tree
	 */
	void enterConstraintCheck(@NotNull sqlParser.ConstraintCheckContext ctx);
	/**
	 * Exit a parse tree produced by the {@code constraintCheck}
	 * labeled alternative in {@link sqlParser#constraintType}.
	 * @param ctx the parse tree
	 */
	void exitConstraintCheck(@NotNull sqlParser.ConstraintCheckContext ctx);
	/**
	 * Enter a parse tree produced by {@link sqlParser#list_values}.
	 * @param ctx the parse tree
	 */
	void enterList_values(@NotNull sqlParser.List_valuesContext ctx);
	/**
	 * Exit a parse tree produced by {@link sqlParser#list_values}.
	 * @param ctx the parse tree
	 */
	void exitList_values(@NotNull sqlParser.List_valuesContext ctx);
	/**
	 * Enter a parse tree produced by {@link sqlParser#float_literal}.
	 * @param ctx the parse tree
	 */
	void enterFloat_literal(@NotNull sqlParser.Float_literalContext ctx);
	/**
	 * Exit a parse tree produced by {@link sqlParser#float_literal}.
	 * @param ctx the parse tree
	 */
	void exitFloat_literal(@NotNull sqlParser.Float_literalContext ctx);
	/**
	 * Enter a parse tree produced by the {@code literal_float}
	 * labeled alternative in {@link sqlParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral_float(@NotNull sqlParser.Literal_floatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code literal_float}
	 * labeled alternative in {@link sqlParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral_float(@NotNull sqlParser.Literal_floatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code literal_char}
	 * labeled alternative in {@link sqlParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral_char(@NotNull sqlParser.Literal_charContext ctx);
	/**
	 * Exit a parse tree produced by the {@code literal_char}
	 * labeled alternative in {@link sqlParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral_char(@NotNull sqlParser.Literal_charContext ctx);
	/**
	 * Enter a parse tree produced by {@link sqlParser#drop_schema_statement}.
	 * @param ctx the parse tree
	 */
	void enterDrop_schema_statement(@NotNull sqlParser.Drop_schema_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link sqlParser#drop_schema_statement}.
	 * @param ctx the parse tree
	 */
	void exitDrop_schema_statement(@NotNull sqlParser.Drop_schema_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link sqlParser#select_value}.
	 * @param ctx the parse tree
	 */
	void enterSelect_value(@NotNull sqlParser.Select_valueContext ctx);
	/**
	 * Exit a parse tree produced by {@link sqlParser#select_value}.
	 * @param ctx the parse tree
	 */
	void exitSelect_value(@NotNull sqlParser.Select_valueContext ctx);
	/**
	 * Enter a parse tree produced by {@link sqlParser#value}.
	 * @param ctx the parse tree
	 */
	void enterValue(@NotNull sqlParser.ValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link sqlParser#value}.
	 * @param ctx the parse tree
	 */
	void exitValue(@NotNull sqlParser.ValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link sqlParser#date_literal}.
	 * @param ctx the parse tree
	 */
	void enterDate_literal(@NotNull sqlParser.Date_literalContext ctx);
	/**
	 * Exit a parse tree produced by {@link sqlParser#date_literal}.
	 * @param ctx the parse tree
	 */
	void exitDate_literal(@NotNull sqlParser.Date_literalContext ctx);
	/**
	 * Enter a parse tree produced by the {@code manipulationAlterTable}
	 * labeled alternative in {@link sqlParser#sql_schema_manipulation_statement}.
	 * @param ctx the parse tree
	 */
	void enterManipulationAlterTable(@NotNull sqlParser.ManipulationAlterTableContext ctx);
	/**
	 * Exit a parse tree produced by the {@code manipulationAlterTable}
	 * labeled alternative in {@link sqlParser#sql_schema_manipulation_statement}.
	 * @param ctx the parse tree
	 */
	void exitManipulationAlterTable(@NotNull sqlParser.ManipulationAlterTableContext ctx);
	/**
	 * Enter a parse tree produced by the {@code manipulationAlterDataBase}
	 * labeled alternative in {@link sqlParser#sql_schema_manipulation_statement}.
	 * @param ctx the parse tree
	 */
	void enterManipulationAlterDataBase(@NotNull sqlParser.ManipulationAlterDataBaseContext ctx);
	/**
	 * Exit a parse tree produced by the {@code manipulationAlterDataBase}
	 * labeled alternative in {@link sqlParser#sql_schema_manipulation_statement}.
	 * @param ctx the parse tree
	 */
	void exitManipulationAlterDataBase(@NotNull sqlParser.ManipulationAlterDataBaseContext ctx);
	/**
	 * Enter a parse tree produced by {@link sqlParser#drop_table_statement}.
	 * @param ctx the parse tree
	 */
	void enterDrop_table_statement(@NotNull sqlParser.Drop_table_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link sqlParser#drop_table_statement}.
	 * @param ctx the parse tree
	 */
	void exitDrop_table_statement(@NotNull sqlParser.Drop_table_statementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code tableDefinition}
	 * labeled alternative in {@link sqlParser#sql_schema_definition_statement}.
	 * @param ctx the parse tree
	 */
	void enterTableDefinition(@NotNull sqlParser.TableDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code tableDefinition}
	 * labeled alternative in {@link sqlParser#sql_schema_definition_statement}.
	 * @param ctx the parse tree
	 */
	void exitTableDefinition(@NotNull sqlParser.TableDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code manipulationRenameTable}
	 * labeled alternative in {@link sqlParser#sql_schema_manipulation_statement}.
	 * @param ctx the parse tree
	 */
	void enterManipulationRenameTable(@NotNull sqlParser.ManipulationRenameTableContext ctx);
	/**
	 * Exit a parse tree produced by the {@code manipulationRenameTable}
	 * labeled alternative in {@link sqlParser#sql_schema_manipulation_statement}.
	 * @param ctx the parse tree
	 */
	void exitManipulationRenameTable(@NotNull sqlParser.ManipulationRenameTableContext ctx);
	/**
	 * Enter a parse tree produced by the {@code manipulationUseSchema}
	 * labeled alternative in {@link sqlParser#sql_schema_manipulation_statement}.
	 * @param ctx the parse tree
	 */
	void enterManipulationUseSchema(@NotNull sqlParser.ManipulationUseSchemaContext ctx);
	/**
	 * Exit a parse tree produced by the {@code manipulationUseSchema}
	 * labeled alternative in {@link sqlParser#sql_schema_manipulation_statement}.
	 * @param ctx the parse tree
	 */
	void exitManipulationUseSchema(@NotNull sqlParser.ManipulationUseSchemaContext ctx);
	/**
	 * Enter a parse tree produced by {@link sqlParser#column}.
	 * @param ctx the parse tree
	 */
	void enterColumn(@NotNull sqlParser.ColumnContext ctx);
	/**
	 * Exit a parse tree produced by {@link sqlParser#column}.
	 * @param ctx the parse tree
	 */
	void exitColumn(@NotNull sqlParser.ColumnContext ctx);
	/**
	 * Enter a parse tree produced by the {@code constraintPrimaryKey}
	 * labeled alternative in {@link sqlParser#constraintType}.
	 * @param ctx the parse tree
	 */
	void enterConstraintPrimaryKey(@NotNull sqlParser.ConstraintPrimaryKeyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code constraintPrimaryKey}
	 * labeled alternative in {@link sqlParser#constraintType}.
	 * @param ctx the parse tree
	 */
	void exitConstraintPrimaryKey(@NotNull sqlParser.ConstraintPrimaryKeyContext ctx);
	/**
	 * Enter a parse tree produced by {@link sqlParser#insert_value}.
	 * @param ctx the parse tree
	 */
	void enterInsert_value(@NotNull sqlParser.Insert_valueContext ctx);
	/**
	 * Exit a parse tree produced by {@link sqlParser#insert_value}.
	 * @param ctx the parse tree
	 */
	void exitInsert_value(@NotNull sqlParser.Insert_valueContext ctx);
	/**
	 * Enter a parse tree produced by {@link sqlParser#schema_definition}.
	 * @param ctx the parse tree
	 */
	void enterSchema_definition(@NotNull sqlParser.Schema_definitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link sqlParser#schema_definition}.
	 * @param ctx the parse tree
	 */
	void exitSchema_definition(@NotNull sqlParser.Schema_definitionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code manipulationDropSchema}
	 * labeled alternative in {@link sqlParser#sql_schema_manipulation_statement}.
	 * @param ctx the parse tree
	 */
	void enterManipulationDropSchema(@NotNull sqlParser.ManipulationDropSchemaContext ctx);
	/**
	 * Exit a parse tree produced by the {@code manipulationDropSchema}
	 * labeled alternative in {@link sqlParser#sql_schema_manipulation_statement}.
	 * @param ctx the parse tree
	 */
	void exitManipulationDropSchema(@NotNull sqlParser.ManipulationDropSchemaContext ctx);
	/**
	 * Enter a parse tree produced by {@link sqlParser#update_value}.
	 * @param ctx the parse tree
	 */
	void enterUpdate_value(@NotNull sqlParser.Update_valueContext ctx);
	/**
	 * Exit a parse tree produced by {@link sqlParser#update_value}.
	 * @param ctx the parse tree
	 */
	void exitUpdate_value(@NotNull sqlParser.Update_valueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code dataStatement}
	 * labeled alternative in {@link sqlParser#sql_executable_statement}.
	 * @param ctx the parse tree
	 */
	void enterDataStatement(@NotNull sqlParser.DataStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code dataStatement}
	 * labeled alternative in {@link sqlParser#sql_executable_statement}.
	 * @param ctx the parse tree
	 */
	void exitDataStatement(@NotNull sqlParser.DataStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link sqlParser#constraint}.
	 * @param ctx the parse tree
	 */
	void enterConstraint(@NotNull sqlParser.ConstraintContext ctx);
	/**
	 * Exit a parse tree produced by {@link sqlParser#constraint}.
	 * @param ctx the parse tree
	 */
	void exitConstraint(@NotNull sqlParser.ConstraintContext ctx);
	/**
	 * Enter a parse tree produced by {@link sqlParser#show_table_statement}.
	 * @param ctx the parse tree
	 */
	void enterShow_table_statement(@NotNull sqlParser.Show_table_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link sqlParser#show_table_statement}.
	 * @param ctx the parse tree
	 */
	void exitShow_table_statement(@NotNull sqlParser.Show_table_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link sqlParser#relational}.
	 * @param ctx the parse tree
	 */
	void enterRelational(@NotNull sqlParser.RelationalContext ctx);
	/**
	 * Exit a parse tree produced by {@link sqlParser#relational}.
	 * @param ctx the parse tree
	 */
	void exitRelational(@NotNull sqlParser.RelationalContext ctx);
	/**
	 * Enter a parse tree produced by {@link sqlParser#logic}.
	 * @param ctx the parse tree
	 */
	void enterLogic(@NotNull sqlParser.LogicContext ctx);
	/**
	 * Exit a parse tree produced by {@link sqlParser#logic}.
	 * @param ctx the parse tree
	 */
	void exitLogic(@NotNull sqlParser.LogicContext ctx);
	/**
	 * Enter a parse tree produced by the {@code manipulationShowSchema}
	 * labeled alternative in {@link sqlParser#sql_schema_manipulation_statement}.
	 * @param ctx the parse tree
	 */
	void enterManipulationShowSchema(@NotNull sqlParser.ManipulationShowSchemaContext ctx);
	/**
	 * Exit a parse tree produced by the {@code manipulationShowSchema}
	 * labeled alternative in {@link sqlParser#sql_schema_manipulation_statement}.
	 * @param ctx the parse tree
	 */
	void exitManipulationShowSchema(@NotNull sqlParser.ManipulationShowSchemaContext ctx);
}