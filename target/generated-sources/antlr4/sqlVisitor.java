// Generated from sql.g4 by ANTLR 4.4
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link sqlParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface sqlVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link sqlParser#use_schema_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUse_schema_statement(@NotNull sqlParser.Use_schema_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link sqlParser#tipo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTipo(@NotNull sqlParser.TipoContext ctx);
	/**
	 * Visit a parse tree produced by {@link sqlParser#table_definition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTable_definition(@NotNull sqlParser.Table_definitionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code literal_date}
	 * labeled alternative in {@link sqlParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral_date(@NotNull sqlParser.Literal_dateContext ctx);
	/**
	 * Visit a parse tree produced by the {@code accionDropColumn}
	 * labeled alternative in {@link sqlParser#accion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAccionDropColumn(@NotNull sqlParser.AccionDropColumnContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expLogic}
	 * labeled alternative in {@link sqlParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpLogic(@NotNull sqlParser.ExpLogicContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expRelational}
	 * labeled alternative in {@link sqlParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpRelational(@NotNull sqlParser.ExpRelationalContext ctx);
	/**
	 * Visit a parse tree produced by {@link sqlParser#int_literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInt_literal(@NotNull sqlParser.Int_literalContext ctx);
	/**
	 * Visit a parse tree produced by the {@code executableDataStatement}
	 * labeled alternative in {@link sqlParser#sql_executable_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExecutableDataStatement(@NotNull sqlParser.ExecutableDataStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link sqlParser#alter_table_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlter_table_statement(@NotNull sqlParser.Alter_table_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link sqlParser#alter_database_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlter_database_statement(@NotNull sqlParser.Alter_database_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link sqlParser#sql2003Parser}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSql2003Parser(@NotNull sqlParser.Sql2003ParserContext ctx);
	/**
	 * Visit a parse tree produced by {@link sqlParser#delete_value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDelete_value(@NotNull sqlParser.Delete_valueContext ctx);
	/**
	 * Visit a parse tree produced by {@link sqlParser#char_literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitChar_literal(@NotNull sqlParser.Char_literalContext ctx);
	/**
	 * Visit a parse tree produced by the {@code accionAddColumn}
	 * labeled alternative in {@link sqlParser#accion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAccionAddColumn(@NotNull sqlParser.AccionAddColumnContext ctx);
	/**
	 * Visit a parse tree produced by the {@code executableSchemaStatement}
	 * labeled alternative in {@link sqlParser#sql_executable_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExecutableSchemaStatement(@NotNull sqlParser.ExecutableSchemaStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code schemaDefinitionStatement}
	 * labeled alternative in {@link sqlParser#sql_schema_definition_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSchemaDefinitionStatement(@NotNull sqlParser.SchemaDefinitionStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link sqlParser#tipo_literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTipo_literal(@NotNull sqlParser.Tipo_literalContext ctx);
	/**
	 * Visit a parse tree produced by {@link sqlParser#condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondition(@NotNull sqlParser.ConditionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code manipulationDropTable}
	 * labeled alternative in {@link sqlParser#sql_schema_manipulation_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitManipulationDropTable(@NotNull sqlParser.ManipulationDropTableContext ctx);
	/**
	 * Visit a parse tree produced by {@link sqlParser#rename_table_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRename_table_statement(@NotNull sqlParser.Rename_table_statementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code schemaManipulationStatement}
	 * labeled alternative in {@link sqlParser#sql_schema_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSchemaManipulationStatement(@NotNull sqlParser.SchemaManipulationStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code literal_int}
	 * labeled alternative in {@link sqlParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral_int(@NotNull sqlParser.Literal_intContext ctx);
	/**
	 * Visit a parse tree produced by {@link sqlParser#show_column_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShow_column_statement(@NotNull sqlParser.Show_column_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link sqlParser#sql_data_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSql_data_statement(@NotNull sqlParser.Sql_data_statementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code schemaStatement}
	 * labeled alternative in {@link sqlParser#sql_schema_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSchemaStatement(@NotNull sqlParser.SchemaStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link sqlParser#show_schema_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShow_schema_statement(@NotNull sqlParser.Show_schema_statementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code constraintForeignKey}
	 * labeled alternative in {@link sqlParser#constraintType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstraintForeignKey(@NotNull sqlParser.ConstraintForeignKeyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code manipulationShowTable}
	 * labeled alternative in {@link sqlParser#sql_schema_manipulation_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitManipulationShowTable(@NotNull sqlParser.ManipulationShowTableContext ctx);
	/**
	 * Visit a parse tree produced by the {@code accionDropConstraint}
	 * labeled alternative in {@link sqlParser#accion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAccionDropConstraint(@NotNull sqlParser.AccionDropConstraintContext ctx);
	/**
	 * Visit a parse tree produced by the {@code accionAddConstraint}
	 * labeled alternative in {@link sqlParser#accion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAccionAddConstraint(@NotNull sqlParser.AccionAddConstraintContext ctx);
	/**
	 * Visit a parse tree produced by the {@code manipulationShowColumn}
	 * labeled alternative in {@link sqlParser#sql_schema_manipulation_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitManipulationShowColumn(@NotNull sqlParser.ManipulationShowColumnContext ctx);
	/**
	 * Visit a parse tree produced by the {@code constraintCheck}
	 * labeled alternative in {@link sqlParser#constraintType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstraintCheck(@NotNull sqlParser.ConstraintCheckContext ctx);
	/**
	 * Visit a parse tree produced by {@link sqlParser#list_values}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitList_values(@NotNull sqlParser.List_valuesContext ctx);
	/**
	 * Visit a parse tree produced by {@link sqlParser#float_literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFloat_literal(@NotNull sqlParser.Float_literalContext ctx);
	/**
	 * Visit a parse tree produced by the {@code literal_float}
	 * labeled alternative in {@link sqlParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral_float(@NotNull sqlParser.Literal_floatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code literal_char}
	 * labeled alternative in {@link sqlParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral_char(@NotNull sqlParser.Literal_charContext ctx);
	/**
	 * Visit a parse tree produced by {@link sqlParser#drop_schema_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDrop_schema_statement(@NotNull sqlParser.Drop_schema_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link sqlParser#select_value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelect_value(@NotNull sqlParser.Select_valueContext ctx);
	/**
	 * Visit a parse tree produced by {@link sqlParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValue(@NotNull sqlParser.ValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link sqlParser#date_literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDate_literal(@NotNull sqlParser.Date_literalContext ctx);
	/**
	 * Visit a parse tree produced by the {@code manipulationAlterTable}
	 * labeled alternative in {@link sqlParser#sql_schema_manipulation_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitManipulationAlterTable(@NotNull sqlParser.ManipulationAlterTableContext ctx);
	/**
	 * Visit a parse tree produced by the {@code manipulationAlterDataBase}
	 * labeled alternative in {@link sqlParser#sql_schema_manipulation_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitManipulationAlterDataBase(@NotNull sqlParser.ManipulationAlterDataBaseContext ctx);
	/**
	 * Visit a parse tree produced by {@link sqlParser#drop_table_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDrop_table_statement(@NotNull sqlParser.Drop_table_statementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code manipulationRenameTable}
	 * labeled alternative in {@link sqlParser#sql_schema_manipulation_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitManipulationRenameTable(@NotNull sqlParser.ManipulationRenameTableContext ctx);
	/**
	 * Visit a parse tree produced by the {@code manipulationUseSchema}
	 * labeled alternative in {@link sqlParser#sql_schema_manipulation_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitManipulationUseSchema(@NotNull sqlParser.ManipulationUseSchemaContext ctx);
	/**
	 * Visit a parse tree produced by {@link sqlParser#column}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColumn(@NotNull sqlParser.ColumnContext ctx);
	/**
	 * Visit a parse tree produced by the {@code constraintPrimaryKey}
	 * labeled alternative in {@link sqlParser#constraintType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstraintPrimaryKey(@NotNull sqlParser.ConstraintPrimaryKeyContext ctx);
	/**
	 * Visit a parse tree produced by {@link sqlParser#insert_value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInsert_value(@NotNull sqlParser.Insert_valueContext ctx);
	/**
	 * Visit a parse tree produced by {@link sqlParser#schema_definition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSchema_definition(@NotNull sqlParser.Schema_definitionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code tableDefinitionStatement}
	 * labeled alternative in {@link sqlParser#sql_schema_definition_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTableDefinitionStatement(@NotNull sqlParser.TableDefinitionStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code manipulationDropSchema}
	 * labeled alternative in {@link sqlParser#sql_schema_manipulation_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitManipulationDropSchema(@NotNull sqlParser.ManipulationDropSchemaContext ctx);
	/**
	 * Visit a parse tree produced by {@link sqlParser#update_value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUpdate_value(@NotNull sqlParser.Update_valueContext ctx);
	/**
	 * Visit a parse tree produced by {@link sqlParser#constraint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstraint(@NotNull sqlParser.ConstraintContext ctx);
	/**
	 * Visit a parse tree produced by {@link sqlParser#show_table_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShow_table_statement(@NotNull sqlParser.Show_table_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link sqlParser#relational}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelational(@NotNull sqlParser.RelationalContext ctx);
	/**
	 * Visit a parse tree produced by {@link sqlParser#logic}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogic(@NotNull sqlParser.LogicContext ctx);
	/**
	 * Visit a parse tree produced by the {@code manipulationShowSchema}
	 * labeled alternative in {@link sqlParser#sql_schema_manipulation_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitManipulationShowSchema(@NotNull sqlParser.ManipulationShowSchemaContext ctx);
}