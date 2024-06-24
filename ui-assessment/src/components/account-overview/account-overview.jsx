import React from 'react';

import './account-overview.css';
import { Header } from './header/header';
import { Overview } from './overview/overview';




export const AccountOverview = ({data}) => {
  console.log(data);

  return (
    <>
      <div className="AccountOverview">
        <Header data={data?.supportContact} />
        <Overview data={data?.salesOverview}/>
        {/* <FontAwesomeIcon icon={faHardHat} /> */}
        {/* Build your components here */}
      </div>
    </>
  )
}

export default AccountOverview;