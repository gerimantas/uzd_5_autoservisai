<#import "blocks/template.ftlh" as t>
<@t.template user>
    <h1 style="text-align: center">Autorizacija</h1>
    <hr>
    <form action="/login " method="post">
        <div class="form-group">
            <label for="email">Elektroninis paštas </label>
            <input type="email" class="form-control <#if RequestParameters.error??>is-invalid</#if>" id="email" name="username">
            <div id="email" class="invalid-feedback">
                Neteisingas el. paštas
            </div>
        </div>
        <div class="form-group">
            <label for="password">Slaptažodis</label>
            <input type="password" class="form-control <#if RequestParameters.error??>is-invalid</#if>" id="password" name="password">
            <div id="password" class="invalid-feedback">
                Неверный пароль
            </div>
        </div>
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <button type="submit" style="width: 100%" class="btn btn-dark">Įeiti</button>
    </form>
    <hr>
    <h2>Nėra paskyros AUTOSERVISAI ? <a href="/registration">Registruotis!</a></h2>
</@t.template>