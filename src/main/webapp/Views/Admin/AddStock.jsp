<%@ page import="java.sql.Connection" %>
<%@ page import="Util.DBConnectionUtil" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.ResultSet" %>
<%@include file="AdminHeader.jsp" %>

<div class="content-header">
    <div>
        <nav aria-label="breadcrumb">
            <ol class="breadcrumb">
                <li class="breadcrumb-item"><a href="#">Home</a></li>
                <li class="breadcrumb-item"><a href="#">Users</a></li>
                <li class="breadcrumb-item active" aria-current="page">Stock</li>
            </ol>
        </nav>
        <h4 class="content-title content-title-xs">Add Stock</h4>

    </div>
    <div class="info">

    </div>


</div>
<!-- content-header -->


<div class="content-body">
    <form class="form-group" method="get" name="validateBatchForm"
          action="#">
        <div class="row">
            <div class="col">
                <label class="col-form-label col-form-label-lg" for="name">Stock name</label>
                <input id="name" type="text" name="name" value="${stock.name}"
                       class="form-control" required="true" >
            </div>
            <div class="col">
                <label class="col-form-label col-form-label-lg" for="productUnit">Select Product Unit</label>
                <select id="productUnit" class=" form-control col-form-select-lg" name="productUnit"
                        placeholder="Select  product unit"
                        data-value="${income.productUnit}" required>
                    <option value="CRUDE_PALM_OIL" selected>--Select--</option>
                    <option value="CANS">Cans</option>
                    <option value="DRUMS">Drums</option>
                    <option value="BAGS_50KG">50kg Bags</option>
                    <option value="BAGS_25KG">25Kg Bags</option>

                    <%--                    <option class="form-control" value="<%=selectedBatchName%>"><%=selectedBatchName%>--%>
                    </option>
                </select>
            </div>
            <div class="col">
                <label class="col-form-label col-form-label-lg" for="price">Selling Price</label>
                <input id="price" type="number" name="sellingPrice" value="${stock.Price}"
                       class="form-control" required="true" >
            </div>
        </div>
        <div class="row">
            <div class="col">
                <label class="col-form-label col-form-label-lg" for="qty">Quantity</label>
                <input id="qty" type="text" name="name" value="${stock.quantity}"
                       class="form-control" required="true" >
            </div>
            <div class="col">
                <label class="col-form-label-lg" for="logger">Payment Logged By:</label>
                <input type="text" id="logger" name="logger" value="${loggedIn.fullName}"
                       placeholder="logger name" class="form-control" disabled/>
            </div>

        </div>
        <br>
        <div class="form-group">
            <button class="btn btn-success" type="submit"> Save</button>
        </div>

    </form>
    <span class="alert">${message}</span>



</div>
<!-- content -->
<%@include file="AdminFooter.jsp" %>
