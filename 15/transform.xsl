<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="html" encoding="UTF-8" />

    <xsl:key name="payroll" match="Plan" use="Payroll" />

    <xsl:template match="/">
        <html>
            <head>
                <title>Тарифы мобильных компаний</title>
                <style>
                    table { width: 100%; border-collapse: collapse; }
                    th, td { border: 1px solid black; padding: 8px; text-align: left; }
                    th { background-color: #f2f2f2; }
                </style>
            </head>
            <body>
                <h1>Тарифы мобильных компаний</h1>
                <table>
                    <tr>
                        <th>Название тарифа</th>
                        <th>Оператор</th>
                        <th>Абонентская плата (руб.)</th>
                        <th>Звонки внутри сети (руб./мин.)</th>
                        <th>Звонки вне сети (руб./мин.)</th>
                        <th>Звонки на стационарные телефоны (руб./мин.)</th>
                        <th>Цена за СМС (руб.)</th>
                        <th>Любимый номер</th>
                        <th>Тарификация</th>
                        <th>Плата за подключение (руб.)</th>
                    </tr>
                    <xsl:for-each select="Tariff/Plan">
                        <xsl:sort select="Payroll" data-type="number" order="ascending" />
                        <tr>
                            <td><xsl:value-of select="Name" /></td>
                            <td><xsl:value-of select="OperatorName" /></td>
                            <td><xsl:value-of select="Payroll" /></td>
                            <td><xsl:value-of select="CallPrices/InsideNetwork" /></td>
                            <td><xsl:value-of select="CallPrices/OutsideNetwork" /></td>
                            <td><xsl:value-of select="CallPrices/Landline" /></td>
                            <td><xsl:value-of select="SMSPrice" /></td>
                            <td><xsl:value-of select="Parameters/FavoriteNumber" /></td>
                            <td><xsl:value-of select="Parameters/Tariffication" /></td>
                            <td><xsl:value-of select="Parameters/ConnectionFee" /></td>
                        </tr>
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>