<%@include file="AdminHeader.jsp" %>

<div class="content-header">
    <div>
        <nav aria-label="breadcrumb">
            <ol class="breadcrumb">
                <li class="breadcrumb-item"><a href="#">Home</a></li>
                <li class="breadcrumb-item"><a href="#">Transactions</a></li>
                <li class="breadcrumb-item active" aria-current="page">Make Sales</li>
            </ol>
        </nav>
        <h4 class="content-title content-title-xs">Make Sales</h4>

    </div>
    <div class="info">

    </div>


</div>
<!-- content-header -->
<div class="content-body">
    <form method="POST" action="${pageContext.request.contextPath}/sellMill">
        <div class="row">
            <div class="col">
                <label class="col-form-label col-form-label-lg" for="incomeType">Product</label>
                <select id="incomeType" class=" form-control col-form-select-lg" name="product"
                        placeholder="Select Income Type"
                        data-value="${income.incomeType}" required>
                    <option value="CRUDE_PALM_OIL">Crude Palm Oil</option>
                    <option value="FIBRE_PALM_OIL">Fibre Palm Oil</option>
                    </option>
                </select>
            </div>
            <div class="col">
                <label class="col-form-label col-form-label-lg" for="productUnit"> Product Unit</label>
                <select id="productUnit" class=" form-control col-form-select-lg" name="productUnit"
                        placeholder="Select  product unit"
                        data-value="${income.productUnit}" required>
                    <option value="CANS">Cans</option>
                    <option value="DRUMS">Drums</option>

                    </option>
                </select>
            </div>
        </div>
        <div class="row">
            <div class="col">
                <label class="col-form-label col-form-label-lg" for="amount">Unit Price
                    <span>(&#8358;)</span></label>
                <input id="amount" type="number" name="unitPrice" value="${income.amount}"
                       class="form-control" required="true" min="0" step=".01"><br>
            </div>oil
            <div class="col">
                <label class="col-form-label col-form-label-lg" for="unitsSold">Units Sold</label>
                <input id="unitsSold" type="number" name="unitsSold" value="${income.amount}"
                       class="form-control" required="true" min="0" step=".01"><br>
            </div>
            <div class="col">
                <label class="col-form-label col-form-label-lg" for="receivedFrom">Payment Received From</label>
                <input id="receivedFrom" type="text" name="receivedFrom" value="${income.receivedFrom}"
                       class="form-control" required="true"><br>
            </div>

        </div>
        <div class="row">

            <div class="col">
                <label for="date" class="col-form-label-lg">Date Received</label>
                <input id="date" type="Date" name="date" value="${income.date}" placeholder="Date" class="form-control"
                       required="true"><br>
            </div>
            <div class="col">
                <label class="col-form-label-lg" for="logger">Payment Logged By:</label>
                <input type="text" id="logger" name="logger" value="${loggedIn.fullName}"
                       placeholder="logger name" class="form-control" disabled/>
            </div>
        </div>

        <div class="row">
            <div class="col">
                <label class="col-form-label col-form-label-lg" for="remark">Remark </label>
                <textarea id="remark" name="remark" value="${income.remark}"
                          class="form-control" required="true" rows="3"></textarea>
            </div>
        </div>
        <div class="row">
            <div class="col">
                <input type="hidden" value="${income.id}" name="id"/>
            </div>
        </div>
        </br>

        <div class="form-group">
            <button class="btn btn-primary" type="submit">Save!</button>
        </div>


    </form>
</div>
<!-- content-body -->
</div><!-- content -->
<%@include file="AdminFooter.jsp" %>
