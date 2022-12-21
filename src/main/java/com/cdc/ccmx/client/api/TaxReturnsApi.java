package com.cdc.ccmx.client.api;

import com.cdc.ccmx.client.ApiCallback;
import com.cdc.ccmx.client.ApiClient;
import com.cdc.ccmx.client.ApiException;
import com.cdc.ccmx.client.ApiResponse;
import com.cdc.ccmx.client.Configuration;
import com.cdc.ccmx.client.Pair;
import com.cdc.ccmx.client.ProgressRequestBody;
import com.cdc.ccmx.client.ProgressResponseBody;
import com.cdc.ccmx.client.model.Errors;
import com.cdc.ccmx.client.model.ResponseNotFound;
import com.cdc.ccmx.client.model.ResponseUnauthorized;
import com.cdc.ccmx.client.model.TaxpayerTaxReturnCollection;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;

import org.threeten.bp.OffsetDateTime;

import java.util.UUID;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TaxReturnsApi {
    private ApiClient apiClient;
    public TaxReturnsApi() {
        this(Configuration.getDefaultApiClient());
    }
    public TaxReturnsApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }
    public ApiClient getApiClient() {
        return apiClient;
    }
    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }
    
    public okhttp3.Call getTaxReturnDataCall(String xApiKey, String xRequestId, UUID id, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        String localVarPath = "/tax-returns/{id}/data"
            .replaceAll("\\{" + "id" + "\\}", apiClient.escapeString(id.toString()));
        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        if (xApiKey != null)
        localVarHeaderParams.put("x-api-key", apiClient.parameterToString(xApiKey));
        if (xRequestId != null)
        localVarHeaderParams.put("x-request-id", apiClient.parameterToString(xRequestId));
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();
        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);
        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);
        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new okhttp3.Interceptor() {
                @Override
                public okhttp3.Response intercept(okhttp3.Interceptor.Chain chain) throws IOException {
                    okhttp3.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }
        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }
    @SuppressWarnings("rawtypes")
    private okhttp3.Call getTaxReturnDataValidateBeforeCall(String xApiKey, String xRequestId, UUID id, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        if (xApiKey == null) {
            throw new ApiException("Missing the required parameter 'xApiKey' when calling getTaxReturnData(Async)");
        }
        if (xRequestId == null) {
            throw new ApiException("Missing the required parameter 'xRequestId' when calling getTaxReturnData(Async)");
        }
        if (id == null) {
            throw new ApiException("Missing the required parameter 'id' when calling getTaxReturnData(Async)");
        }
        
        okhttp3.Call call = getTaxReturnDataCall(xApiKey, xRequestId, id, progressListener, progressRequestListener);
        return call;
    }
    
    public Object getTaxReturnData(String xApiKey, String xRequestId, UUID id) throws ApiException {
        ApiResponse<Object> resp = getTaxReturnDataWithHttpInfo(xApiKey, xRequestId, id);
        return resp.getData();
    }
    
    public ApiResponse<Object> getTaxReturnDataWithHttpInfo(String xApiKey, String xRequestId, UUID id) throws ApiException {
        okhttp3.Call call = getTaxReturnDataValidateBeforeCall(xApiKey, xRequestId, id, null, null);
        Type localVarReturnType = new TypeToken<Object>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }
    
    public okhttp3.Call getTaxReturnDataAsync(String xApiKey, String xRequestId, UUID id, final ApiCallback<Object> callback) throws ApiException {
        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;
        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };
            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }
        okhttp3.Call call = getTaxReturnDataValidateBeforeCall(xApiKey, xRequestId, id, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<Object>(){}.getType();
        apiClient.execute(call, localVarReturnType);
        return call;
    }
    
    public okhttp3.Call listTaxpayerTaxReturnCall(String xApiKey, String xRequestId, String id, Double operationNumber, String type, String intervalUnit, String complementary, String captureLine, String period, OffsetDateTime presentedAtBefore, OffsetDateTime presentedAtStrictlyBefore, OffsetDateTime presentedAtAfter, OffsetDateTime presentedAtStrictlyAfter, String fiscalYear, String orderPeriod, String orderPresentedAt, Integer page, Integer itemsPerPage, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        String localVarPath = "/taxpayers/{id}/tax-returns"
            .replaceAll("\\{" + "id" + "\\}", apiClient.escapeString(id.toString()));
        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (operationNumber != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("operationNumber", operationNumber));
        if (type != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("type", type));
        if (intervalUnit != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("intervalUnit", intervalUnit));
        if (complementary != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("complementary", complementary));
        if (captureLine != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("captureLine", captureLine));
        if (period != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("period", period));
        if (presentedAtBefore != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("presentedAt[before]", presentedAtBefore));
        if (presentedAtStrictlyBefore != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("presentedAt[strictly_before]", presentedAtStrictlyBefore));
        if (presentedAtAfter != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("presentedAt[after]", presentedAtAfter));
        if (presentedAtStrictlyAfter != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("presentedAt[strictly_after]", presentedAtStrictlyAfter));
        if (fiscalYear != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("fiscalYear", fiscalYear));
        if (orderPeriod != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("order[period]", orderPeriod));
        if (orderPresentedAt != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("order[presentedAt]", orderPresentedAt));
        if (page != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("page", page));
        if (itemsPerPage != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("itemsPerPage", itemsPerPage));
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        if (xApiKey != null)
        localVarHeaderParams.put("x-api-key", apiClient.parameterToString(xApiKey));
        if (xRequestId != null)
        localVarHeaderParams.put("x-request-id", apiClient.parameterToString(xRequestId));
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();
        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);
        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);
        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new okhttp3.Interceptor() {
                @Override
                public okhttp3.Response intercept(okhttp3.Interceptor.Chain chain) throws IOException {
                    okhttp3.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }
        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }
    @SuppressWarnings("rawtypes")
    private okhttp3.Call listTaxpayerTaxReturnValidateBeforeCall(String xApiKey, String xRequestId, String id, Double operationNumber, String type, String intervalUnit, String complementary, String captureLine, String period, OffsetDateTime presentedAtBefore, OffsetDateTime presentedAtStrictlyBefore, OffsetDateTime presentedAtAfter, OffsetDateTime presentedAtStrictlyAfter, String fiscalYear, String orderPeriod, String orderPresentedAt, Integer page, Integer itemsPerPage, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        if (xApiKey == null) {
            throw new ApiException("Missing the required parameter 'xApiKey' when calling listTaxpayerTaxReturn(Async)");
        }
        if (xRequestId == null) {
            throw new ApiException("Missing the required parameter 'xRequestId' when calling listTaxpayerTaxReturn(Async)");
        }
        if (id == null) {
            throw new ApiException("Missing the required parameter 'id' when calling listTaxpayerTaxReturn(Async)");
        }
        
        okhttp3.Call call = listTaxpayerTaxReturnCall(xApiKey, xRequestId, id, operationNumber, type, intervalUnit, complementary, captureLine, period, presentedAtBefore, presentedAtStrictlyBefore, presentedAtAfter, presentedAtStrictlyAfter, fiscalYear, orderPeriod, orderPresentedAt, page, itemsPerPage, progressListener, progressRequestListener);
        return call;
    }
    
    public TaxpayerTaxReturnCollection listTaxpayerTaxReturn(String xApiKey, String xRequestId, String id, Double operationNumber, String type, String intervalUnit, String complementary, String captureLine, String period, OffsetDateTime presentedAtBefore, OffsetDateTime presentedAtStrictlyBefore, OffsetDateTime presentedAtAfter, OffsetDateTime presentedAtStrictlyAfter, String fiscalYear, String orderPeriod, String orderPresentedAt, Integer page, Integer itemsPerPage) throws ApiException {
        ApiResponse<TaxpayerTaxReturnCollection> resp = listTaxpayerTaxReturnWithHttpInfo(xApiKey, xRequestId, id, operationNumber, type, intervalUnit, complementary, captureLine, period, presentedAtBefore, presentedAtStrictlyBefore, presentedAtAfter, presentedAtStrictlyAfter, fiscalYear, orderPeriod, orderPresentedAt, page, itemsPerPage);
        return resp.getData();
    }
    
    public ApiResponse<TaxpayerTaxReturnCollection> listTaxpayerTaxReturnWithHttpInfo(String xApiKey, String xRequestId, String id, Double operationNumber, String type, String intervalUnit, String complementary, String captureLine, String period, OffsetDateTime presentedAtBefore, OffsetDateTime presentedAtStrictlyBefore, OffsetDateTime presentedAtAfter, OffsetDateTime presentedAtStrictlyAfter, String fiscalYear, String orderPeriod, String orderPresentedAt, Integer page, Integer itemsPerPage) throws ApiException {
        okhttp3.Call call = listTaxpayerTaxReturnValidateBeforeCall(xApiKey, xRequestId, id, operationNumber, type, intervalUnit, complementary, captureLine, period, presentedAtBefore, presentedAtStrictlyBefore, presentedAtAfter, presentedAtStrictlyAfter, fiscalYear, orderPeriod, orderPresentedAt, page, itemsPerPage, null, null);
        Type localVarReturnType = new TypeToken<TaxpayerTaxReturnCollection>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }
    
    public okhttp3.Call listTaxpayerTaxReturnAsync(String xApiKey, String xRequestId, String id, Double operationNumber, String type, String intervalUnit, String complementary, String captureLine, String period, OffsetDateTime presentedAtBefore, OffsetDateTime presentedAtStrictlyBefore, OffsetDateTime presentedAtAfter, OffsetDateTime presentedAtStrictlyAfter, String fiscalYear, String orderPeriod, String orderPresentedAt, Integer page, Integer itemsPerPage, final ApiCallback<TaxpayerTaxReturnCollection> callback) throws ApiException {
        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;
        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };
            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }
        okhttp3.Call call = listTaxpayerTaxReturnValidateBeforeCall(xApiKey, xRequestId, id, operationNumber, type, intervalUnit, complementary, captureLine, period, presentedAtBefore, presentedAtStrictlyBefore, presentedAtAfter, presentedAtStrictlyAfter, fiscalYear, orderPeriod, orderPresentedAt, page, itemsPerPage, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<TaxpayerTaxReturnCollection>(){}.getType();
        apiClient.execute(call, localVarReturnType);
        return call;
    }
}
