import React from 'react'
import PaymentConfirmed from '../components/PaymentConfirmed'

const PaymentConfirmedPage = () => {
  return (
    <>
      <section className="ellipses">
        <div className="ellipse ellipse1"></div>
        <div className="ellipse ellipse2"></div>
        <div className="ellipse ellipse3"></div>
        <div className="ellipse ellipse4"></div>
      </section>
      <div className="glass overflow-hidden">
        <PaymentConfirmed />
      </div>
    </>
  );
}

export default PaymentConfirmedPage