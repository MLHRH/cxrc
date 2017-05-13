package com.jfn.common.pager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;

public class PaginationHelper<E> {

    @SuppressWarnings("unchecked")
	public Page<E> fetchPage(
            final JdbcTemplate jt,
            final String sqlCountRows,
            final String sqlFetchRows,
            final Object args[],
            final int pageNo,
            final int pageSize,
            final ParameterizedRowMapper<E> rowMapper) {

        // determine how many rows are available
        final int rowCount = jt.queryForInt(sqlCountRows, args);

        // calculate the number of pages
        int pageCount = rowCount / pageSize;
        if (rowCount > pageSize * pageCount) {
            pageCount++;
        }

        // create the page object
        final Page<E> page = new Page<E>();
        page.setPageNumber(pageNo);
        page.setPagesAvailable(pageCount);
        page.setRowCount( rowCount );

        // fetch a single page of results
        final int startRow = (pageNo - 1) * pageSize;
        jt.query(
                sqlFetchRows,
                args,
                new ResultSetExtractor<Object>() {
                    @Override
					public Object extractData(ResultSet rs) throws SQLException, DataAccessException {
                        final List<E> pageItems = page.getPageItems();
                        int currentRow = 0;
                        while (rs.next() && currentRow < startRow + pageSize) {
                            if (currentRow >= startRow) {
                                pageItems.add(rowMapper.mapRow(rs, currentRow));
                            }
                            currentRow++;
                        }
                        return page;
                    }
                });
        return page;
    }
    
    public Page<E> fetchMysqlPage1(
            final NamedParameterJdbcTemplate npjt,
            final String sqlCountRows,
            String sqlFetchRows,
            final Map<String,?> args,
            final int startRow,
            final int pageSize,
            final ParameterizedRowMapper<E> rowMapper) {

        final int rowCount = npjt.queryForInt(sqlCountRows, args);

        int pageCount = rowCount / pageSize;
        if (rowCount > pageSize * pageCount) {
            pageCount++;
        }

        int pageNo = (startRow+1)/pageSize;
        if( (startRow+1) > pageNo * pageSize )
        {    
        	pageNo++;
        }
        final Page<E> page = new Page<E>();
        page.setPageNumber(pageNo);
        page.setPagesAvailable(pageCount);
        
        page.setRowCount( rowCount );

        sqlFetchRows = sqlFetchRows + String.format( " limit %d,%d",startRow, pageSize);
        npjt.query(
                sqlFetchRows,
                args,
                new ResultSetExtractor<Object>()
				{
					@Override
					public Object extractData( ResultSet rs ) throws SQLException,
							DataAccessException
					{
						final List<E> pageItems = page.getPageItems();
                        int currentRow = 0;
                        while (rs.next()) {
                            pageItems.add(rowMapper.mapRow(rs, currentRow));
                            currentRow++;
                        }
                        return page;
					}
				});
        return page;
    }
    
    public Page<E> fetchMysqlPage2(
            final JdbcTemplate jt,
            final String sqlCountRows,
            String sqlFetchRows,
            final Object args[],
            final int startRow,
            final int pageSize,
            final ParameterizedRowMapper<E> rowMapper) {

        final int rowCount = jt.queryForInt(sqlCountRows, args);

        int pageCount = rowCount / pageSize;
        if (rowCount > pageSize * pageCount) {
            pageCount++;
        }

        final int pageNo = startRow/pageSize + 1; 
        final Page<E> page = new Page<E>();
        page.setPageNumber(pageNo);
        page.setPagesAvailable(pageCount);
        
        page.setRowCount( rowCount );

        sqlFetchRows = sqlFetchRows + String.format( " limit %d,%d",startRow, pageSize);
        
        jt.query(
                sqlFetchRows,
                args,
                new ResultSetExtractor<Object>() {
                    @Override
					public Object extractData(ResultSet rs) throws SQLException, DataAccessException {
                        final List<E> pageItems = page.getPageItems();
                        int currentRow = 0;
                        while (rs.next()) {
                            pageItems.add(rowMapper.mapRow(rs, currentRow));
                            currentRow++;
                        }
                        return page;
                    }
                });
        return page;
    }
}